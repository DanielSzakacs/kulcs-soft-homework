import { Component, OnInit } from '@angular/core';
import {CookieHandlerService} from "../cookie-service/cookie-handler.service";
import {MainPageComponent} from "../main-page/main-page.component";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  listOfUsers : object;
  links = environment;

  constructor(private adminCookieHandler: CookieHandlerService, private mainPageComponent : MainPageComponent,
              private http : HttpClient) { }

  ngOnInit() {
    this.getAllUser();
  }

  logout(){
    this.adminCookieHandler.logout();
    this.mainPageComponent.checkUserCookie();
  }

  saveUser(data){
    this.http.post(this.links.mainUrl + "/saveuser", data).subscribe(res => {
      this.getAllUser();
    },
      error1 => {
      console.log(error1)
      });
  }

  getAllUser(){
    this.http.get(this.links.mainUrl + "/get_all_user").subscribe(res => {
      this.listOfUsers = res;
    },
      error1 => {
      console.log(error1);
      })
  }

  deleteUser(email : string){
    console.log('this is the useremil when deleting it. ' + email);
    this.http.delete(this.links.mainUrl + "/delete_user?user=" + email).subscribe(res => {
      console.log(res);
      this.getAllUser();
    },
      error1 => {
      console.log(error1)
      });
    this.getAllUser();
  }
}
