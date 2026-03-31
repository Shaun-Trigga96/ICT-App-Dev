import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomepageComponent} from "./homepage/homepage.component";
import {CreateuserComponent} from "./createuser/createuser.component";
import {EdituserComponent} from "./edituser/edituser.component";
import {CreatemovieComponent} from "./createmovie/createmovie.component";
import {ViewmoviesComponent} from "./viewmovies/viewmovies.component";
import {RentreturnMovieComponent} from "./rentreturn-movie/rentreturn-movie.component";
import {ViewusersComponent} from "./viewusers/viewusers.component";
import { ViewrentalsComponent } from './viewrentals/viewrentals.component';

const routes: Routes = [
  {
    path:'',
    component: HomepageComponent
  },
  {
    path: 'createuser',
    component: CreateuserComponent
  },
  {
    path:'edituser',
    component: EdituserComponent
  },
  {
    path:'createmovie',
    component: CreatemovieComponent
  },
  {
    path:'viewmovie',
    component: ViewmoviesComponent
  },
  {
    path:'rentreturnmovie',
    component: RentreturnMovieComponent

  },
  {
    path:'viewusers',
    component: ViewusersComponent

  },
  {
    path:'viewrentals',
    component: ViewrentalsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
