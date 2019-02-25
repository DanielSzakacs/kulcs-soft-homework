import { Injectable } from '@angular/core';
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class CookieHandlerService {

  constructor(private cookie : CookieService) { }

    login(adminData ){
    this.cookie.set('admin', adminData['email']);
  }

   logout(){
    this.cookie.delete('admin');
  }

  isUserLoggedIn(){
    return this.cookie.check('admin');
  }
}
