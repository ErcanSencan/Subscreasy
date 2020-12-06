import { Injectable } from '@angular/core';
import {CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService : AuthService, private router: Router){}
  async canActivate(){
    let control : boolean
    await this.authService.IsLoggedIn().then(value=>{control=value;});
    if (control){
      return true;
    }else{
      this.router.navigate(['login']);
      return false;
    }
  }  
}
