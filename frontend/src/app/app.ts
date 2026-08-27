import { Component, signal } from '@angular/core';
import { ProductoLista } from "./productos/producto-lista/producto-lista";
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  imports: [RouterModule, RouterLink, RouterLinkActive, RouterOutlet]
})
export class App {
  protected readonly title = signal('inventario-app');
}
