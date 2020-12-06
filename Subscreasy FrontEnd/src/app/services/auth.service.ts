import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiController = '/login'
  constructor(
    private http: HttpClient, 
    private router: Router,
    @Inject('apiUrl') private apiUrl
    ) {}

  
  GetToken(obj){   
    return this.http.post(this.apiUrl+this.apiController,obj,{observe: 'response'});
  } 


   async IsLoggedIn(): Promise<boolean>{
    if(localStorage.getItem('token') == null && sessionStorage.getItem('token') == null){return false;}
    else
    {
      let control : boolean
      await this.http.get(this.apiUrl+'/logincheck').toPromise().then(() => control = true)
      .catch(() => control = false);
      console.log(control);
      return control;
    }
  }

}
