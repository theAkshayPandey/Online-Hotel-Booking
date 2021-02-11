import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './componenets/dashboard/dashboard.component'
import { SearchResultComponent } from './componenets/search-result/search-result.component';
import { HotelDetailComponent } from './componenets/hotel-detail/hotel-detail.component';
import { BookingComponent } from './componenets/booking/booking.component';
import { ConfirmComponent } from './componenets/confirm/confirm.component';
import { FailureComponent } from './componenets/failure/failure.component';

const routes: Routes = [
  {path : '',component:DashboardComponent},
  {path : 'search-result',component:SearchResultComponent},
  {path : 'hotel-detail/:hid/:rid',component:HotelDetailComponent},
  {path : 'auth',loadChildren: () => import('./componenets/auth/auth.module').then(m=>m.AuthModule)},
  {path : 'booking',component:BookingComponent,data : {selected_room_data : null}},
  {path : 'confirm',component:ConfirmComponent,data : {booking_detail : null}},
  {path : 'fail',component:FailureComponent}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
