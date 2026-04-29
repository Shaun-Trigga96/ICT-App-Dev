import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {rentalHistory} from "../entity/rentalHistory";
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root'})
export class RentalHistoryService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getRentalHistory(): Observable<rentalHistory[]> {
    return this.http.get<rentalHistory[]> (`${this.apiServerUrl}/userrental/getall`)
  }

  public addRentalHistory(rentalHistory : rentalHistory): Observable<rentalHistory> {
    return this.http.post<rentalHistory> (`${this.apiServerUrl}/userrental/create`,rentalHistory)
  }

  public updateRentalHistory(user : rentalHistory): Observable<rentalHistory> {
    return this.http.put<rentalHistory> (`${this.apiServerUrl}/userrental/update`,user)
  }

  public deleteRentalHistory(rentalId : string): Observable<void> {
    return this.http.delete<void> (`${this.apiServerUrl}/userrental/delete${rentalId}`)
  }
}
