import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[],filterString: string,propName:string): any[] {
    let resultArray= [];

    if (value.length === 0 || filterString === '' || propName === '')
    {
      return value;
    }

    // filtering the given array list
    for ( const item of value)
    {
      if (item[propName].toLocaleLowerCase().match(filterString.toLocaleLowerCase())  )
      {
        resultArray.push(item);
      }
    }

    // if resultArray empty add all the value in it
    if (resultArray.length === 0)
    {
      resultArray = value;
    }
    return resultArray;
  }

}
