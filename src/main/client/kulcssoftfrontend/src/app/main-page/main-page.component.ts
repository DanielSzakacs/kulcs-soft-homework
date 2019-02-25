import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";
import {AlertsService} from "angular-alert-module";
import {CookieHandlerService} from "../cookie-service/cookie-handler.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  links = environment;
  adminLoggedIn = this.adminCookieHandler.isUserLoggedIn();

  constructor(private http : HttpClient, private alerts : AlertsService, private adminCookieHandler : CookieHandlerService){}

  ngOnInit() {
    this.alerts.setDefaults('timeout',2);
  }

  registration(data) {
    this.http.post(this.links.mainUrl + "/registration", data).subscribe(res => {
      this.alerts.setMessage('Your registration is succeed', 'success');
      this.ngOnInit();
    },
      error1 => {
      this.alerts.setMessage('Something wrong try registration latter', 'warn');
      })
  }

  adminlogin(data){
    this.http.post(this.links.mainUrl + "/login", data).subscribe(res =>{
        this.adminCookieHandler.login(data);
        this.alerts.setMessage('You logged in', 'success');
        this.checkUserCookie();
    },
      error1 => {
        console.log(error1);
        this.alerts.setMessage('Something woring please try it again', 'warn');
      })
  }

  checkUserCookie(){
    this.adminLoggedIn = this.adminCookieHandler.isUserLoggedIn();
  }

}
