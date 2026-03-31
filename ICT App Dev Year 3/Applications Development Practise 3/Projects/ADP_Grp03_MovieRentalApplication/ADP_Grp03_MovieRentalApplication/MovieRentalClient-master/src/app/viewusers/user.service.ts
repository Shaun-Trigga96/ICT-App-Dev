import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../entity/user";

@Injectable({ providedIn: 'root'})
export class UserService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]> (`${this.apiServerUrl}/user/getall`)
  }

  public addUser(user : User): Observable<User> {
    return this.http.post<User> (`${this.apiServerUrl}/user/create`,user)
  }

  public updateUser(user : User): Observable<User> {
    return this.http.put<User> (`${this.apiServerUrl}/usr/update`,user)
  }

  public deleteUser(userId : string): Observable<void> {
    return this.http.delete<void> (`${this.apiServerUrl}/user/delete${userId}`)
  }
}
