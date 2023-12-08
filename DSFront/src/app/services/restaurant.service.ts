import {Injectable} from '@angular/core';
import {EvaluationDto, RestaurantDto} from "../models/dto/restaurant.dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { UrlDto } from '../models/dto/url.dto';
import {AddRestaurantFormData} from "../components/restaurant/add-restaurant-form/add-restaurant-form.component";
import { AddEvaluationFormData } from '../components/restaurant-detail/add-evaluation-form/add-evaluation-form.component';
import { EditRestaurantFormData } from '../components/restaurant-detail/edit-restaurant-form/edit-restaurant-form.component';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  public getRestaurantById(Id: number): Observable<RestaurantDto> {
    return this.httpClient.get<RestaurantDto>(`http://localhost:8080/restaurants/${Id}`);
  }

  constructor(private httpClient: HttpClient) {
    this.loadRestaurants();
  }

  public loadRestaurants(): Observable<RestaurantDto[]> {
    return this.httpClient.get<RestaurantDto[]>(`http://localhost:8080/restaurants`)
  }

  public addRestaurant(newRestaurantData: AddRestaurantFormData): Observable<RestaurantDto> {
    return this.httpClient.post<RestaurantDto>(`http://localhost:8080/restaurants`, newRestaurantData);
  }
 
  public deleteEvaluation(IdRestaurant: number, IdEvaluation: number) {
    return this.httpClient.delete<RestaurantDto>(`http://localhost:8080/restaurants/${IdRestaurant}/evaluations/${IdEvaluation}`);
  }

  public editRestaurant(IdRestaurant: number, editRestaurantData: EditRestaurantFormData) {
    return this.httpClient.put<RestaurantDto>(`http://localhost:8080/restaurants/${IdRestaurant}`,editRestaurantData);
  }

}
