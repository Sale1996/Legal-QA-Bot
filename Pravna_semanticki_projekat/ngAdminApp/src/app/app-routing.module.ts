import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CodeBookComponent } from './components/code-book/code-book.component';
import { AddEntityComponent } from './components/add-entity/add-entity.component';

const routes: Routes = [
  { path: 'home', component: CodeBookComponent},
  { path: 'add-new', component: AddEntityComponent},
  { path: '**', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
