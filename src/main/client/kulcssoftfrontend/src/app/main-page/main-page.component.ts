import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  links = environment;

  constructor(private http : HttpClient) { }

  ngOnInit() {
  }

  registration(data) {
    this.http.post(this.links.mainUrl + "/registration", data).subscribe(res => {
      console.log(res)
    },
      error1 => {
      console.log(error1)
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
