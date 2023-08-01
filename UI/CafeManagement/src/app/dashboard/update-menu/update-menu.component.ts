import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { MenuItem } from 'src/model/menu-item.model';

@Component({
  selector: 'app-update-menu',
  templateUrl: './update-menu.component.html',
  styleUrls: ['./update-menu.component.css']
})
export class UpdateMenuComponent implements OnInit{

  id!: string;

  menuItem : MenuItem = new MenuItem();

  constructor(private menuService : MenuService, private activatedRoute : ActivatedRoute, private router: Router){}

  ngOnInit(): void {
      this.id = this.activatedRoute.snapshot.params['id']; // to get the menu item id in the router 

      this.menuService.getMenuItemById(this.id).subscribe(data => {
        console.log(data);
        this.menuItem = data;
      },
      error => console.error('Error in updating menu item', error));
  }

  onSubmit(){
    this.menuService.updateMenuItem(this.id, this.menuItem).subscribe( data =>{
      this.goToMenu();
    },
    error => console.error('Error in updating menu item', error));
  }

  goToMenu() {
    this.router.navigate(['/dashboard-menu']);
  }

}
