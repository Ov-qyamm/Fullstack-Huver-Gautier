import { Component } from '@angular/core';
import { EvaluationDto, RestaurantDto } from '../../models/dto/restaurant.dto';
import { ActivatedRoute, Router } from '@angular/router';
import { ColorRestaurant } from '../../directives/color-restaurant';
import { CommonModule, NgOptimizedImage } from '@angular/common';
import { RestaurantService } from '../../services/restaurant.service';
import { AddEvaluationFormData, AddEvaluationFormComponent } from './add-evaluation-form/add-evaluation-form.component';
import { EvaluationService } from '../../services/evaluation.service';
import { EditRestaurantFormData, EditRestaurantFormComponent } from './edit-restaurant-form/edit-restaurant-form.component';


@Component({
    selector: 'app-restaurant-detail',
    standalone: true,
    templateUrl: './restaurant-detail.component.html',
    styleUrl: './restaurant-detail.component.css',
    imports: [CommonModule, NgOptimizedImage, ColorRestaurant, AddEvaluationFormComponent, EditRestaurantFormComponent]
})

export class RestaurentDetailComponent {

  public restaurant?: RestaurantDto;
  public evaluations?: EvaluationDto;

  constructor(private router: Router,
             private restaurantService: RestaurantService,
             private evaluationService: EvaluationService,
             private activatedRoute: ActivatedRoute) {
  }

  public ngOnInit(): void {
    this.activatedRoute.params.subscribe(value => {
        this.restaurantService.getRestaurantById(value['id']).subscribe(restaurant => this.restaurant = restaurant);
    });
  }

  public RetourListeRestaurant(): void {
    this.router.navigate([`/`])
  }

  SupprimerEvaluation(IdRestaurant: number, IdEvaluation: number):void {
      this.restaurantService.deleteEvaluation(IdRestaurant, IdEvaluation).subscribe();
  }

  public onEvaluationSubmitted(IdRestaurant: number, newEvaluationData: AddEvaluationFormData): void {
    this.evaluationService.addEvaluation(IdRestaurant, newEvaluationData).subscribe()
  }
  
  public onRestaurantEditSubmitted(IdRestaurant: number, editRestaurantData: EditRestaurantFormData): void {
      this.restaurantService.editRestaurant(IdRestaurant, editRestaurantData).subscribe()
  }   

}
