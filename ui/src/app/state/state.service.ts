import { Injectable } from '@angular/core';
import { Visit } from './visit.model';


@Injectable({
  providedIn: 'root'
})
export class StateService {

  public persons: string[] = [];
  public visit: Visit;


}
