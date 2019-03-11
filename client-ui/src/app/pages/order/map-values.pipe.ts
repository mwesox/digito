import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mapValues'
})
export class MapValuesPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    const v: Map<string, object> = value;
    let result = new Array();

    for(let key of Array.from( v.keys()) ) {
      result.push(v.get(key)[0]);
    }

    console.log(result);
    return result;
  }

}
