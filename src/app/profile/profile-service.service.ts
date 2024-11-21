import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileServiceService {
  private userProfile: any;

  constructor() { }

 
  setUserProfile(profile: any) {
    this.userProfile = profile;
  }

 
  getUserProfile() {
    return this.userProfile;
  }

  
}

