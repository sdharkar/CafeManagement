import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminDashboardComponent } from './dashboard/admin-dashboard/admin-dashboard.component';
import { InventoryComponent } from './inventory/inventory.component';
import { UpdateInventoryComponent } from './update-inventory/update-inventory.component';
import { DashboardMenuComponent } from './dashboard/dashboard-menu/dashboard-menu.component';
import { DashboardContentComponent } from './dashboard/dashboard-content/dashboard-content.component';
import { UpdateMenuComponent } from './dashboard/update-menu/update-menu.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PaymentComponent } from './payment/payment.component';
import { DashboardPaymentComponent } from './dashboard/dashboard-payment/dashboard-payment.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';


const routes: Routes = [
  {path:'home', component: HomePageComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'menu', component: MenuComponent},
  {path: 'order', component: OrderComponent},
  {path: 'profile', component: UserProfileComponent},
  {path: 'dashboard', component: AdminDashboardComponent},
  {path: 'inventory', component: InventoryComponent},
  {path: 'update-inventory/:id', component: UpdateInventoryComponent},
  {path: 'dashboard-menu', component: DashboardMenuComponent},
  {path: 'dashboard-content', component: DashboardContentComponent},
  {path: 'update-menu/:id', component: UpdateMenuComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path:'payment', component: PaymentComponent},
  {path:'dashboard-payment', component: DashboardPaymentComponent},
  {path:'forbidden', component: ForbiddenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
