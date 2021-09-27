import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivosFormComponent } from './components/Activos/activos-form.component';
import { ActivosComponent } from './components/Activos/activos.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'grados'},
  {path: 'activos', component: ActivosComponent},
  {path: 'activos/form', component: ActivosFormComponent},
  {path: 'activos/form/:id', component: ActivosFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
