import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuItem } from 'src/model/menu-item.model';
import { MenuService } from '../service/menu.service';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-search-menu-name',
  templateUrl: './search-menu-name.component.html',
  styleUrls: ['./search-menu-name.component.css']
})
export class SearchMenuNameComponent implements OnInit {
  
  menuItems!: MenuItem[];

  menuItem: MenuItem = new MenuItem();

  name!: string;

  constructor(
    private menuService: MenuService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private orderService: OrderService
  ) {}


  
  ngOnInit(): void {
    this.name = this.activatedRoute.snapshot.params["name"];
  this.menuService.getMenuItemByName(this.name).subscribe(data=>{
    this.menuItem = data;
  }, error => console.log(error));
  }

  public searchName1(){
    console.log('printed')
    let response= this.menuService.getMenuItemByName(this.name);
    response.subscribe((data:any) => this.name=data);
    console.log(this.name)
  }

  // ngOnInit(): void {
  //   this.searchName();
  // }


  
  //display content
  showSearchResultByName: boolean = false;
  toggleShowSearchResultByName() {
    this.showSearchResultByName = !this.showSearchResultByName;
  }

  //search by name
  searchName(): void {
    this.name = this.activatedRoute.snapshot.params['name'];
    this.menuService.getMenuItemByName(this.name).subscribe(
      (data) => {
        this.menuItem = data;
        console.log('Search by name successful ', data);
      },
      (error) => console.error('Error in search by name ', error)
    );
  }

  //Add to cart
  addToCart(id: string) {
    this.menuService.addToCart(id).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => console.error('Error in adding to cart', error)
    );
  }

}
