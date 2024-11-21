import { Component } from '@angular/core';
import { LoginServiceService } from './login-service.service';
import { ProfileServiceService } from '../profile/profile-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(
    protected crud: LoginServiceService,
    private profileService: ProfileServiceService, 
    private router: Router 
  ) {}
  profile: any; 

  Submit(data: any) {
      if (data.valid) {
          console.log('Form submitted:', data.value);
          
          this.crud.login(data.value).subscribe((res: any) => { 
              console.log(res);
              this.profile = res; 
              this.profileService.setUserProfile(res);
               this.router.navigate(['/profile']); 
          }, (error: any) => {
              console.error('Login failed:', error);
              alert('Login failed! Please check your credentials.');
          });
          
      } else {
          console.log('Form is invalid, please check your inputs.');
      }
  }
}
