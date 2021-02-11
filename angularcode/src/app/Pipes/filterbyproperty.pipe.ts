import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterbyproperty'
})
export class FilterbypropertyPipe implements PipeTransform {

  transform(value: any[],filterArray: any[]): any[] {
    const resultArray = [];

    if (filterArray.length === 0)
    {
      return value;
    }


    for (let index = 0; index < value.length; index++) {
      const element = value[index];
      if ( filterArray.includes(element["hotel_type"]) )
      {
        resultArray.push(element);
      }
      
    }
    
    return resultArray;
  }

}
