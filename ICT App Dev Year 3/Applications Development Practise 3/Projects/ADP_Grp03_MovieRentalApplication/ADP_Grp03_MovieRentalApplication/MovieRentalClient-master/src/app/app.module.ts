import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieService } from './service/movie.service';
import { HomepageComponent } from './homepage/homepage.component';
import { CreatemovieComponent } from './createmovie/createmovie.component';
import { ViewmoviesComponent } from './viewmovies/viewmovies.component';

import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";

import {CreateuserComponent} from "./createuser/createuser.component";
import {EdituserComponent} from "./edituser/edituser.component";
import {RentreturnMovieComponent} from "./rentreturn-movie/rentreturn-movie.component";
import { FormsModule } from '@angular/forms';
import { ViewusersComponent } from './viewusers/viewusers.component';
import { ViewrentalsComponent } from './viewrentals/viewrentals.component';


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CreatemovieComponent,
    ViewmoviesComponent,
    CreateuserComponent,
    EdituserComponent,
    RentreturnMovieComponent,
    HeaderComponent,
    FooterComponent,
    ViewusersComponent,
    ViewrentalsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
