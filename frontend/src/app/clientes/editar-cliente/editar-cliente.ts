import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-cliente',
  imports: [FormsModule],
  templateUrl: './editar-cliente.html'
})
export class EditarCliente implements OnInit {

   cliente: Cliente = new Cliente();
   id: number;
  
   private clienteServicio=inject(ClienteService);
   private ruta = inject (ActivatedRoute);
   private enrutador = inject(Router);
   private cdr = inject(ChangeDetectorRef)


  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.clienteServicio.obtenerClientePorId(this.id).subscribe({
      next: (datos) =>{ this.cliente = datos
        this.cdr.detectChanges();
      },
      error: (errores: any) => console.log(errores)
    });
  }

  onSubmit(){
    this.guardarCliente();
  }

  guardarCliente(){
     this.clienteServicio.editarCliente(this.id, this.cliente).subscribe({
      next:(datos)=> this.irListaClientes(),
      error: (errores) => console.log(errores)
     })
  }
  irListaClientes(){
    this.enrutador.navigate(['/cliente'])
  }

}
    

