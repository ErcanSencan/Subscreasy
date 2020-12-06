import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {
  constructor(private authService : AuthService, private router: Router,public snackBar : MatSnackBar) { }

  ngOnInit() {
  }

  GetToken(email: HTMLInputElement, password: HTMLInputElement, rememberMe: HTMLInputElement){
    const loginObj = {
      username: email.value,
      password: password.value
    };  
      this.authService.GetToken(loginObj).subscribe((resp:any) =>{
      if(rememberMe.checked){ 
        localStorage.setItem('token',resp.headers.get('Authorization'));
        sessionStorage.removeItem('token');
      }
      else{
        sessionStorage.setItem('token',resp.headers.get('Authorization'));
        localStorage.removeItem('token');
      }
      this.GotoHome();
      this.openSnackBar("Welcome");
      
    },
    err=>{
      console.log(err);
      this.openSnackBar("Username or Password is Wrong");
    }
    );
    
  
  }

  GotoRegister(){
    this.router.navigate(['register']);
  }
  GotoHome(){
    this.router.navigate(['home']);
  }
  openSnackBar(message : string){
    this.snackBar.open(message,"Ok",{duration: 2000});
  }

 

}
