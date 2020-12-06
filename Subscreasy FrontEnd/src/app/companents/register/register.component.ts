import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private userService : UserService, private router: Router,public snackBar : MatSnackBar) { }

  ngOnInit() {
  }

  RegisterUser(username: HTMLInputElement, password: HTMLInputElement, repeat_password: HTMLInputElement, name: HTMLInputElement, lastname: HTMLInputElement){  
    var checkUser = this.validateUserFields(username.value,password.value,repeat_password.value,name.value,lastname.value);
    if(checkUser){
      const user = {
        userName: username.value,
        password: password.value,
        name: name.value,
        lastName: lastname.value
      };
       this.userService.RegisterUser(user).subscribe((resp:any) =>{
       this.router.navigate(['login']);
       this.openSnackBar("User Registered");
      },
      err=>{
        console.log(err);
        this.openSnackBar("Something is wrong");
      }
      );
    }  
  }

  openSnackBar(message : string){
    this.snackBar.open(message,"Ok",{duration: 2000});
  }

  private validateUserFields(username : String,password : String, repeat_password : String,name:String,lastname:String){
    if(!(username.trim().length > 3)){
      this.openSnackBar("Fill UserName");
      return false;
    }else if(!(password.trim().length > 4) || !(password === repeat_password) ){
      this.openSnackBar("Fill Passwords");
      return false;
    }else if(!(name.trim().length > 1)){
      this.openSnackBar("Fill Name");
      return false;
    } else if(!(lastname.trim().length > 1)){
      this.openSnackBar("Fill LastName");
      return false;
    }
    return true;
  }
}
