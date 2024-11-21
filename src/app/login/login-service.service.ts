import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  constructor(protected http:HttpClient) { }

  public login(data:any){
    console.log(data);
    return this.http.post('https://registrationandtodo-production.up.railway.app/login',data);
  }
}
