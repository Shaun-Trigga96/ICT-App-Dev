import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { rentalHistory } from '../entity/rentalHistory';
import { RentalHistoryService } from '../service/rentalHistory.service';

@Component({
  selector: 'app-rentreturn-movie',
  templateUrl: './rentreturn-movie.component.html',
  styleUrls: ['./rentreturn-movie.component.css']
})
export class RentreturnMovieComponent implements OnInit {
  public rentalHistories: rentalHistory[] = [];
  constructor(private rentalHistoryService: RentalHistoryService) { }

  ngOnInit(): void {
  }

  public getRentalHistory():void {
    this.rentalHistoryService.getRentalHistory().subscribe(
      (response: rentalHistory[]) => {
        this.rentalHistories = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }

  public onAddRentalHistory(addForm:NgForm): void{
      this.rentalHistoryService.addRentalHistory(addForm.value).subscribe(
        (response: rentalHistory)=>{
          console.log(response);
          this.getRentalHistory();
          alert("saved");
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
        }
      );
  }


  public onReturnMovie(rentalHistory: rentalHistory): void{
    this.rentalHistoryService.updateRentalHistory(rentalHistory).subscribe(
      (response: rentalHistory)=>{
        console.log(response);
        this.getRentalHistory();
        alert("saved");
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
}
}
