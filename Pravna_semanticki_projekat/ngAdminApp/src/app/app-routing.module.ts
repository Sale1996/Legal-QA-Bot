import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CodeBookComponent } from './components/code-book/code-book.component';
import { AddEntityComponent } from './components/add-entity/add-entity.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './_shared/auth-guard.service';

const routes: Routes = [
  { path: 'home', component: CodeBookComponent},
  { path: 'add-new', component: AddEntityComponent},
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
