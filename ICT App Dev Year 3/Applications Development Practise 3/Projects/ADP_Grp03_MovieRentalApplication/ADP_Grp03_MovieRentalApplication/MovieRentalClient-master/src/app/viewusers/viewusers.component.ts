import { Component, OnInit } from '@angular/core';
import {User} from "../entity/user";
import {UserService} from "./user.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-viewusers',
  templateUrl: './viewusers.component.html',
  styleUrls: ['./viewusers.component.css']
})
export class ViewusersComponent implements OnInit {
  public users: User[] = [];
  constructor(private userService: UserService) { }

  ngOnInit(){
    this.getUsers();
  }
  public getUsers():void {
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }

}
