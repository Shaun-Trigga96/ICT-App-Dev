import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Movie } from '../entity/movie';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-createmovie',
  templateUrl: './createmovie.component.html',
  styleUrls: ['./createmovie.component.css']
})
export class CreatemovieComponent implements OnInit {
  public movies: Movie[] = [];
  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
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

  public onAddMovie(addForm:NgForm): void{
      this.movieService.addMovie(addForm.value).subscribe(
        (response: Movie)=>{
          console.log(response);
          this.getMovies();
          alert("saved");
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
        }
      );
  }
}
