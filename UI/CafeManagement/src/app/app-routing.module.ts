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
import { AuthGuard } from './auth/auth.guard';
import { NormalGuard } from './auth/normal.guard';
import { SearchMenuNameComponent } from './search-menu-name/search-menu-name.component';


const routes: Routes = [
  {path:'home', component: HomePageComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'menu', component: MenuComponent},
  {path: 'order', component: OrderComponent,canActivate:[NormalGuard]},
  {path: 'profile', component: UserProfileComponent,canActivate:[NormalGuard] },
  {path: 'dashboard', component: AdminDashboardComponent, canActivate:[AuthGuard] },
  {path: 'inventory', component: InventoryComponent, canActivate:[AuthGuard]},
  {path: 'update-inventory/:id', component: UpdateInventoryComponent, canActivate:[AuthGuard]},
  {path: 'dashboard-menu', component: DashboardMenuComponent,canActivate:[AuthGuard]},
  {path: 'dashboard-content', component: DashboardContentComponent, canActivate:[AuthGuard]},
  {path: 'update-menu/:id', component: UpdateMenuComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path:'payment', component: PaymentComponent, canActivate:[NormalGuard]},
  {path:'dashboard-payment', component: DashboardPaymentComponent, canActivate:[AuthGuard]},
  {path:'forbidden', component: ForbiddenComponent},
  {path:'search/:name', component: SearchMenuNameComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
