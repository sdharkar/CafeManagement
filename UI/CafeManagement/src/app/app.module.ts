import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SidebarComponent } from './dashboard/sidebar/sidebar.component';
import { DashboardHeaderComponent } from './dashboard/dashboard-header/dashboard-header.component';
import { DashboardContentComponent } from './dashboard/dashboard-content/dashboard-content.component';
import { AdminDashboardComponent } from './dashboard/admin-dashboard/admin-dashboard.component';
import { MenuService } from './service/menu.service';
import { InventoryService } from './service/inventory.service';
import { OrderService } from './service/order.service';
import { PaymentService } from './service/payment.service';
import { UserService } from './service/user.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { InventoryComponent } from './inventory/inventory.component';
import { DashboardMenuComponent } from './dashboard/dashboard-menu/dashboard-menu.component';
import { UpdateInventoryComponent } from './update-inventory/update-inventory.component';
import { DashboardPaymentComponent } from './dashboard/dashboard-payment/dashboard-payment.component';
import { DashboardUserComponent } from './dashboard/dashboard-user/dashboard-user.component';
import { UpdateMenuComponent } from './dashboard/update-menu/update-menu.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import { UserAuthService } from './service/user-auth.service';
import { RouterModule } from '@angular/router';
import { AuthGuard} from './auth/auth.guard';
import { AuthInterceptor } from './auth/auth.interceptor';
import { ForbiddenComponent } from './forbidden/forbidden.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    MenuComponent,
    OrderComponent,
    UserProfileComponent,
    SidebarComponent,
    DashboardHeaderComponent,
    DashboardContentComponent,
    AdminDashboardComponent,
    InventoryComponent,
    DashboardMenuComponent,
    UpdateInventoryComponent,
    DashboardPaymentComponent,
    DashboardUserComponent,
    UpdateMenuComponent,
    LoginComponent,
    SignupComponent,
    CartComponent,
    PaymentComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    MenuService,
    InventoryService,
    OrderService,
    PaymentService,
    UserService,
    UserAuthService,
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
