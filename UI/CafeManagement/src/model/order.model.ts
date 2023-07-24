import { MenuItem } from "./menu-item.model";

export interface Order {
    id: string;
    userId: string;
    items: OrderItem[];
    totalAmount: number;
    status: string;
}

export interface OrderItem {
    itemId: string;
    quantity: number;
}