import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { rentalHistory } from '../entity/rentalHistory';
import { RentalHistoryService } from '../service/rentalHistory.service';

@Component({
  selector: 'app-viewrentals',
  templateUrl: './viewrentals.component.html',
  styleUrls: ['./viewrentals.component.css']
})
export class ViewrentalsComponent implements OnInit {
  public rentals: rentalHistory[] = [];

  constructor(private rentalService: RentalHistoryService) {
  }

  ngOnInit(){
    this.getRentals();
  }
  public getRentals():void {
    this.rentalService.getRentalHistory().subscribe(
      (response: rentalHistory[]) => {
        this.rentals = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }
  
}
