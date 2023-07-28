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


const routes: Routes = [
  {path:'', component: HomePageComponent},
  {path: 'menu', component: MenuComponent},
  {path: 'order', component: OrderComponent},
  {path: 'profile', component: UserProfileComponent},
  {path: 'dashboard', component: AdminDashboardComponent},
  {path: 'inventory', component: InventoryComponent},
  {path: 'update-inventory', component: UpdateInventoryComponent},
  {path: 'dashboard-menu', component: DashboardMenuComponent},
  {path: 'dashboard-content', component: DashboardContentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
