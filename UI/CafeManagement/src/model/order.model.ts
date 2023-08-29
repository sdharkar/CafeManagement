import { MenuItem } from "./menu-item.model";
import { User } from "./user.model";


export interface Order extends Document {
    id: string;
    userName: User[];
    Menu: MenuItem[];
    totalAmount: number;
    status: string;
}



