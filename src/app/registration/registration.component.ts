import { Component } from '@angular/core';
import { SignupService } from './signup.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

constructor(protected crud:SignupService){

}
   Submit(data:any){
    if (data.valid) {
      console.log('Form submitted:', data.value);
      this.crud.register(data.value).subscribe(function (res:any){
        console.log(res);
      });
      
    }else{
      console.log('ooops');

    }
  }
}
