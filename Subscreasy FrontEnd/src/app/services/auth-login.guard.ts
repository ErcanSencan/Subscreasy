import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})

export class AuthLoginGuard implements CanActivate {
  constructor(private authService : AuthService, private router: Router){}
   
  async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    let control:boolean
    await this.authService.IsLoggedIn().then(value=>{control = value;});

    if (control == false) {
      return true;
    } else {
      this.router.navigate(['']);
      return false;
    }
  }
  
}
