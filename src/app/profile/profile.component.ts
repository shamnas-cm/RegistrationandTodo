import { Component, OnInit } from '@angular/core';
import { ProfileServiceService } from './profile-service.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  profile: any;

  constructor(private profileService: ProfileServiceService, private translate: TranslateService) {
    // Set default language, you can set this based on user preference or browser settings
    this.translate.setDefaultLang('ml'); // Setting default language to English
    this.translate.use('en'); // Initial language setting to Malayalam
  }

  ngOnInit(): void {
    this.profile = this.profileService.getUserProfile(); // Get the stored user profile
  }

  changeLanguage(language: string) {
    this.translate.use(language); // Change the language
  }
}
