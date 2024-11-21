import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(protected http:HttpClient) { }

  public register(data:any){
    console.log(data);
    return this.http.post('https://registrationandtodo-production.up.railway.app/save',data);
  }
}
