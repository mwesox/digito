import { Injectable } from '@angular/core';
import { IMenuItem, MenuItem } from './menu.model';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  selectedItems: MenuItem[] = new Array();

  constructor() { }


  calculatePrice() {
    return this.selectedItems.reduce((t, item) => t + item.price, 0);
  }

  getSelectedAmount(item: string) {
    // console.log('get selected amount: ' + item);
    return this.selectedItems.filter(f => f.id === item).length;
  }

  removeItem(rm: IMenuItem) {
    for (let i = 0; i < this.selectedItems.length; i++) {
      if (this.selectedItems[i].id === rm.id) {
        this.selectedItems.splice(i, 1);
        break;
      }
    }
  }

  addItem(item: IMenuItem) {
    console.log(name);
    this.selectedItems.push(item);
  }

  getGroupedItems(): Map<string, IMenuItem[]> {
    let map = new Map<string, IMenuItem[]>();

    this.selectedItems.forEach( item => {
      if(map.has(item.name)){
        map.get(item.name).push(item);
      }else{
        map.set(item.name, new Array(item));
      }
    });
    return map;
  }

  getGroupedItemsByAmount(): Map<IMenuItem, number> {
    const map = this.getGroupedItems();
    let resultMap = new Map<IMenuItem, number>();

    for(let key of Array.from( map.keys()) ) {
      const amount: number = map.get(key).length;
      const item: IMenuItem = map.get(key)[0];
      resultMap.set(item, amount);
    }

    return resultMap;
  }



}
