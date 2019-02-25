import { Component, OnInit } from '@angular/core';
import {CookieHandlerService} from "../cookie-service/cookie-handler.service";
import {MainPageComponent} from "../main-page/main-page.component";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  constructor(private adminCookieHandler: CookieHandlerService, private mainPageComponent : MainPageComponent,
              private http : HttpClient) { }

  ngOnInit() {
  }

  logout(){
    this.adminCookieHandler.logout();
    this.mainPageComponent.checkUserCookie();
  }

  saveUser(data){

  }
}
