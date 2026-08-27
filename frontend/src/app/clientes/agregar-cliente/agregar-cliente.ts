import { Component, inject, signal } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-agregar-cliente',
  imports: [FormsModule],
  templateUrl: './agregar-cliente.html'
})

export class AgregarCliente {
  cliente: Cliente = new Cliente();

  private clienteServicio = inject(ClienteService)
  private enrutador=inject(Router);

  onSubmit(){
    this.guardarCliente();
  }

  guardarCliente(){
      this.clienteServicio.agregarCliente(this.cliente).subscribe({
        next: (datos)=>{
          this.irListaClientes();
        },
        error: (error: any) => {console.log(error)}
      })
  }
  irListaClientes(){
    this.enrutador.navigate(['/cliente'])
  }

  
}
