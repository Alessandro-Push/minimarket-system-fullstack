import { Component, inject, OnInit, signal } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [RouterLink],
  templateUrl: './producto-lista.html',
  
})
export class ProductoLista implements OnInit{ 
 // 2. Definir productos como Signal
 productos = signal<Producto[]>([]);

  private productoServicio = inject(ProductoService);
  private enrutador = inject(Router);

  ngOnInit(){
    //Cargar lsop roductos
    this.obtenerProductos();
  }

  private obtenerProductos(): void{
    this.productoServicio.obtenerProductosLista().subscribe(
      {
        next: (datos) =>{
          console.log("¡ÉXITO! Datos cargados:", datos);
         // 3. Asignar los datos usando .set()
          this.productos.set(datos);
        },
        error: (error)=>{
          console.error("Error al obtener los productos", error);
        }
      }
    );
  }


  editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id])
  }

  eliminarProducto(id: number){
    this.productoServicio.eliminarProducto(id).subscribe({
    next: (datos) =>this.obtenerProductos(),
    error:(errores)=> console.log(errores)});
  }
}
