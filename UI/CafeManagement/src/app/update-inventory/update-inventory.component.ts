import { Component, OnInit } from '@angular/core';
import { InventoryItem } from 'src/model/inventory-item.model';
import { InventoryService } from '../service/inventory.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-inventory',
  templateUrl: './update-inventory.component.html',
  styleUrls: ['./update-inventory.component.css']
})
export class UpdateInventoryComponent implements OnInit{
  id!: string;
  inventoryItems: InventoryItem[] =[];

  inventoryItem : InventoryItem = new InventoryItem();



  constructor(private inventoryService: InventoryService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id']; // to get the menu item id in the router 

    this.inventoryService.getInventoryItemById(this.id).subscribe(data => {
      console.log(data);
      this.inventoryItem = data;
    },
    error => console.error('Error in updating inventory item', error));
  }

  onSubmit(){
    this.inventoryService.updateInventoryItem(this.id, this.inventoryItem).subscribe( data => {
      this.goToInventory();
    }, 
  error => console.error('Error in updating inventory item', error));

  
  }

  //Go to inventory
  goToInventory() {
    this.router.navigate(['/inventory']);
  }


}

