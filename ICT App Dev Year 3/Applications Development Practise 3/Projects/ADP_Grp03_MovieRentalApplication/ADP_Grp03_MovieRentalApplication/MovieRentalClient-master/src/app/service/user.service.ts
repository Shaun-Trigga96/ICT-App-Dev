import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../entity/user";
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root'})
export class UserService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getUser(): Observable<User[]> {
    return this.http.get<User[]> (`${this.apiServerUrl}/user/getall`)
  }

  public addUser(user : User): Observable<User> {
    return this.http.post<User> (`${this.apiServerUrl}/user/create`,user)
  }

  public updateUser(user : User): Observable<User> {
    return this.http.put<User> (`${this.apiServerUrl}/user/update`,user)
  }

  public deleteUser(userId : string): Observable<void> {
    return this.http.delete<void> (`${this.apiServerUrl}/user/delete${userId}`)
  }
}
