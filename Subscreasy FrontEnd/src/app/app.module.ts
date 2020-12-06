import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';


import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule, Component } from '@angular/core';
import {MatButtonModule, MatCheckboxModule, MatInputModule, MatCardModule, MatIconModule, MatSnackBarModule} from '@angular/material';
import {DragDropModule} from '@angular/cdk/drag-drop';

import { AppComponent } from './app.component';
import { HomeComponent } from './companents/home/home.component';
import { NotFoundComponent } from './companents/not-found/not-found.component';

import { LoginComponent } from './companents/login/login.component';
import { AuthService } from './services/auth.service';
import { AuthGuard } from './services/auth.guard';
import { AutInterceptor } from './services/auth.interceptor';
import { AuthLoginGuard } from './services/auth-login.guard';
import { RegisterComponent } from './companents/register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatSnackBarModule,
    DragDropModule,
   
  ],
  providers: [UserService, AuthService, AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: AutInterceptor,multi: true},
    {provide: 'apiUrl', useValue: "http://localhost:8087"},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
