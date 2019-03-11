export interface IMenu {
    items: IMenuItem[];

    addItem(item: IMenuItem);
}

export interface IMenuItem {
    id: string;
    name: string;
    price: number;
    description: string;
    foodType: FoodType;
    pictures: string[];
}

export enum FoodType {
    MAIN_DISH,
    DESSERT,
    STARTER
}


export class Menu implements IMenu {
    items: IMenuItem[] = new Array();

    public addItem(item: IMenuItem) {
        this.items.push(item);
    }
}


export class MenuItem implements IMenuItem {

    id: string;
    description: string;
    foodType: FoodType;
    name: string;
    pictures: string[];
    price: number;

    constructor(id: string, description: string, foodType: FoodType, name: string, pictures: string[], price: number) {
        this.id = id;
        this.description = description;
        this.foodType = foodType;
        this.name = name;
        this.pictures = pictures;
        this.price = price;
    }


}
