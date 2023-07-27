
export interface InventoryItem{
    id: string;
    name: string;
    quantity: string;
}


export class InventoryItem{
    id!: string;
    name!: string;
    quantity!: string;
}