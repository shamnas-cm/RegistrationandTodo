import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { TodoComponent } from './todo/todo.component';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import localeEn from '@angular/common/locales/en-IN';
import localeFr from '@angular/common/locales/fr-SY';
import { registerLocaleData } from '@angular/common';

registerLocaleData(localeEn);
registerLocaleData(localeFr);


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    ProfileComponent,
    TodoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TranslateModule.forRoot({
      defaultLanguage: 'en',
      loader: {
        provide: TranslateLoader,
        useFactory: (http: HttpClient) => {

          return new TranslateHttpLoader(http, './assets/i18n/', '.json');
        },
        deps: [HttpClient]
      }
    })
  ],
  providers: [
    {
      provide: LOCALE_ID, useValue:'en-IN'
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
