import { Injectable } from '@angular/core';
import { FoodType, IMenu, Menu, MenuItem } from './menu.model';
import { from, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private data: IMenu;

  constructor() {

    this.data = new Menu();
    this.data.addItem(new MenuItem('1', 'This is just perfect', FoodType.STARTER, 'Fresh salad', null, 5.90));
    this.data.addItem(new MenuItem('2', 'A perfect bavarian main dish', FoodType.MAIN_DISH, 'Bavarian Schweinebraten', null, 15.90));
    this.data.addItem(new MenuItem('3', 'Delicious dessert', FoodType.DESSERT, 'Bavarian Creme', null, 3.90));
    this.data.addItem(new MenuItem('4', 'Delicious dessert', FoodType.DESSERT, 'Bavarian Creme', null, 3.90));
    this.data.addItem(new MenuItem('5', 'Delicious dessert', FoodType.DESSERT, 'Bavarian Creme', null, 3.90));
    this.data.addItem(new MenuItem('6', 'Delicious dessert', FoodType.DESSERT, 'Bavarian Creme', null, 3.90));

  }


  public loadMenu(tableId: string): Observable<IMenu> {
    return of(this.data);
  }

}
