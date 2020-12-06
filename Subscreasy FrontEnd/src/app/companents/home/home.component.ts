import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  
  userName : string
 
  constructor(
    private router : Router,
    private userService : UserService,
  
    ) {}

  ngOnInit() {
      this.GetUser().subscribe((resp:any) =>{
        this.userName = resp.userName;
       },
       err=>{
         console.log(err);
       }
       );

  }

  


  
  GetUser(){
    return this.userService.GetUser();
  }
    

   Logout(){
      localStorage.removeItem('token');
      sessionStorage.removeItem('token');
      this.router.navigate(['login']);
    }
 }




