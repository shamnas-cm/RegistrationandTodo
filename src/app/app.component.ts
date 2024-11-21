import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'registration-app';
  constructor( private translate: TranslateService) {


    // Set default language, you can set this based on user preference or browser settings
    this.translate.setDefaultLang('ml'); // Setting default language to English
    this.translate.use('en'); // Initial language setting to Malayalam
  }

 

  changeLanguage(language: string) {
    this.translate.use(language); // Change the language
  }
}
