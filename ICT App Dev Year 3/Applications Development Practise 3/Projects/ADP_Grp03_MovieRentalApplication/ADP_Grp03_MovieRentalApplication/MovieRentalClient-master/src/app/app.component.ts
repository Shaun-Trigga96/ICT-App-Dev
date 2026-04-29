import { Component, OnInit } from '@angular/core';
import {Movie} from "./entity/movie";
import {MovieService} from "./service/movie.service";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public movies: Movie[] = [];

  constructor(private movieService: MovieService) {
  }

  ngOnInit(){
    this.getMovies();
  }
  public getMovies():void {
    this.movieService.getMovies().subscribe(
      (response: Movie[]) => {
        this.movies = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }
  
}
