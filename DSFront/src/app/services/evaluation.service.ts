import {Injectable} from '@angular/core';
import { EvaluationDto, RestaurantDto } from '../models/dto/restaurant.dto';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { UrlDto } from '../models/dto/url.dto';
import { AddEvaluationFormData } from '../components/restaurant-detail/add-evaluation-form/add-evaluation-form.component';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {
  public getEvaluationById(Id: number): Observable<EvaluationDto> {
    return this.httpClient.get<EvaluationDto>(`http://localhost:8080/evaluations/${Id}`);
  }

  constructor(private httpClient: HttpClient) {
    this.loadEvaluations();
  }

  public loadEvaluations(): Observable<EvaluationDto[]> {
    return this.httpClient.get<EvaluationDto[]>(`http://localhost:8080/evaluations`)
  }



  public addEvaluation(IdRestaurant: number, newEvaluationData: AddEvaluationFormData): Observable <EvaluationDto> {
    return this.httpClient.post<EvaluationDto>(`http://localhost:8080/restaurants/${IdRestaurant}/evaluations`,newEvaluationData)
    }
}
