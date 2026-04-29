import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../entity/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {
  public users: User[] = [];
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  public getUsers():void {
    this.userService.getUser().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }

  public onAddUser(addForm:NgForm): void{
      this.userService.addUser(addForm.value).subscribe(
        (response: User)=>{
          console.log(response);
          this.getUsers();
          alert("saved");
        },
        (error: HttpErrorResponse)=>{
          alert(error.message);
        }
      );
  }
}
