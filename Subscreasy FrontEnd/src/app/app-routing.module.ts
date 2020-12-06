import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './companents/home/home.component';
import { NotFoundComponent } from './companents/not-found/not-found.component';
import { LoginComponent } from './companents/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { AuthLoginGuard } from './services/auth-login.guard';
import { RegisterComponent } from './companents/register/register.component';


const routes: Routes = [
  {
    path: '', component: HomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'home', component: HomeComponent,
    canActivate: [AuthGuard]
  },
 {
    path: 'login', component: LoginComponent,
    canActivate: [AuthLoginGuard]
    
  },
  {
    path: 'register', component: RegisterComponent,
    canActivate: [AuthLoginGuard]
  },
  {
    path: '**', component: NotFoundComponent
  }
   
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
