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
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { InventoryComponent } from './inventory/inventory.component';

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
    InventoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    MenuService,
    InventoryService,
    OrderService,
    PaymentService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
