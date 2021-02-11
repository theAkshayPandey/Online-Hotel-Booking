import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './componenets/nav-bar/nav-bar.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'


import { MaterialModule } from './material.module';
import { FooterComponent } from './componenets/footer/footer.component';
import { DashboardComponent } from './componenets/dashboard/dashboard.component';
import { SearchResultComponent } from './componenets/search-result/search-result.component';

import { NgxSliderModule } from '@angular-slider/ngx-slider';
import { HotelDetailComponent } from './componenets/hotel-detail/hotel-detail.component';



import { NgImageSliderModule } from 'ng-image-slider';

import { AuthModule } from './componenets/auth/auth.module';
import { AuthHeaderInterceptorService } from './services/auth-services/auth-header-interceptor.service';
import { FilterPipe } from './Pipes/filter.pipe';
import { SortdataPipe } from './Pipes/sortdata.pipe';
import { FilterbylocalityPipe } from './Pipes/filterbylocality.pipe';
import { FilterbystarPipe } from './Pipes/filterbystar.pipe';
import { FilterbypropertyPipe } from './Pipes/filterbyproperty.pipe';

import { BookingComponent } from './componenets/booking/booking.component'
import { ConfirmComponent } from './componenets/confirm/confirm.component';
import { FailureComponent } from './componenets/failure/failure.component';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    DashboardComponent,
    SearchResultComponent,
    HotelDetailComponent,
    FilterPipe,
    SortdataPipe,
    FilterbylocalityPipe,
    FilterbystarPipe,
    FilterbypropertyPipe,
    BookingComponent,
    ConfirmComponent,
    FailureComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    NgxSliderModule,
    NgImageSliderModule,
    ReactiveFormsModule ,
    AuthModule,
    FlexLayoutModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthHeaderInterceptorService,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
