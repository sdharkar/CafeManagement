import { Component, OnInit } from '@angular/core';

interface MenuItem {
  name: string;
  description: string;
  price: number;
}


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  
  menuItems: MenuItem[] = [];

  ngOnInit(): void {
      
    this.menuItems = [
      {
        name: 'Espresso',
        description: 'A shot of pure coffee goodness.',
        price: 50,
      },
      {
        name: 'Cappuccino',
        description: 'Equal parts espresso, steamed milk, and foam.',
        price: 70,
      },
      {
        name: 'Croissant',
        description: 'Flaky and buttery pastry, perfect for breakfast.',
        price: 30,
      },
    ];
  }

}
