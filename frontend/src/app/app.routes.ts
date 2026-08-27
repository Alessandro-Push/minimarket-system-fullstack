import { Routes } from '@angular/router';
import { ProductoLista } from './productos/producto-lista/producto-lista';
import { AgregarProducto } from './productos/agregar-producto/agregar-producto';
import { EditarProducto } from './productos/editar-producto/editar-producto';
import { ClienteLista } from './clientes/cliente-lista/cliente-lista';
import { PaginaPrincipal } from './inicio/pagina-principal/pagina-principal';
import { AgregarCliente } from './clientes/agregar-cliente/agregar-cliente';
import { EditarCliente } from './clientes/editar-cliente/editar-cliente';

//http://localhost:4200/productos
export const routes: Routes = [
    {path:'inicio', component: PaginaPrincipal},
    {path:'', redirectTo: 'inicio', pathMatch: 'full'},
    {path: 'inventario', component: ProductoLista},
    {path: 'agregar-producto' , component: AgregarProducto},
    {path: 'editar-producto/:id', component: EditarProducto},
    {path: 'cliente', component:ClienteLista},
    {path:'agregar-cliente', component: AgregarCliente},
    {path:'editar-cliente/:id', component: EditarCliente}
    
];
