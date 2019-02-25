import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";
import {AlertsService} from "angular-alert-module";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  links = environment;

  constructor(private http : HttpClient, private alerts : AlertsService){}

  ngOnInit() {
    this.alerts.setDefaults('timeout',2);
    //this.alerts.setConfig('warn','icon','baseline');
  }

  registration(data) {
    this.http.post(this.links.mainUrl + "/registration", data).subscribe(res => {
      this.alerts.setMessage('Your registration is succeed', 'success');
    },
      error1 => {
      this.alerts.setMessage('Something wrong try registration latter', 'warn');
      })
  }

  login(data){
    console.log('this is the login method');
    this.http.post(this.links.mainUrl + "/login", data).subscribe(res =>{
      console.log(res);
    },
      error1 => {
      console.log(error1)
      })
  }

}
