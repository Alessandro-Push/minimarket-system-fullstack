import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  templateUrl: './editar-producto.html',
 
})
export class EditarProducto implements OnInit {
  producto: Producto = new Producto();
  id:number;

  private productoServicio = inject(ProductoService);
  private ruta = inject (ActivatedRoute);
  private enrutador = inject(Router);
  private cdr = inject(ChangeDetectorRef); 

  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe({
      next: (datos) =>{ this.producto = datos
        this.cdr.detectChanges();
      },
      error: (errores: any) => console.log(errores)
    });
  }

  onSubmit(){
    //editar producto 
    this.guardarProducto();
  }

  guardarProducto(){
    this.productoServicio.editarProducto(this.id, this.producto).subscribe({
      next: (datos)=>this.irListaProductos(),
      error: (errores) => console.log(errores)
    });
  }

  irListaProductos(){
    this.enrutador.navigate(['/inventario'])
  }
}
