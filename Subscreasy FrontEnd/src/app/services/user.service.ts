import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiController = '/user'
  constructor(
    private http: HttpClient, 
    private router: Router,
    @Inject('apiUrl') private apiUrl
    ) {}

    RegisterUser(user){
        return this.http.post(this.apiUrl+this.apiController,user);
    } 

    GetUser(){
        return  this.http.get(this.apiUrl+this.apiController);
    } 
}
