import { Component, inject, signal } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-cliente-lista',
  imports: [RouterLink],
  templateUrl: './cliente-lista.html'
})
export class ClienteLista {

  clientes=signal<Cliente[]>([]);

  private clienteServicio = inject(ClienteService)
  private enrutador=inject(Router);

  ngOnInit(){
    this.obtenerClientes();
  }
  
  editarCliente(id: number){
    this.enrutador.navigate(['editar-cliente', id])
  }
  
  obtenerClientes(){
    this.clienteServicio.obtenerClienteLista().subscribe({
      next: (datos)=>{
        console.log("ÉXITO! datos cargados: ", datos);
        this.clientes.set(datos);
      },
      error: (error) => {
          console.error("Erro al obtener los clientes", error)
      },
    })
  }
  
  eliminarCliente(id:number){
    this.clienteServicio.eliminarCliente(id).subscribe({
      next:(datos)=>this.obtenerClientes(),
      error: (errores) => console.log(errores)
    });
  }


}
