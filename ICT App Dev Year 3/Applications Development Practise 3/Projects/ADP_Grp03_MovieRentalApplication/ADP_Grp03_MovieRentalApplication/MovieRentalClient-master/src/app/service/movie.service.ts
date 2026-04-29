import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../entity/movie";
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root'})
export class MovieService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]> (`${this.apiServerUrl}/movie/getall`)
  }

  public addMovie(movie : Movie): Observable<Movie> {
    return this.http.post<Movie> (`${this.apiServerUrl}/movie/create`,movie)
  }

  public updateMovie(movie : Movie): Observable<Movie> {
    return this.http.put<Movie> (`${this.apiServerUrl}/movie/update`,movie)
  }

  public deleteMovie(movieId : string): Observable<void> {
    return this.http.delete<void> (`${this.apiServerUrl}/movie/delete${movieId}`)
  }
}
