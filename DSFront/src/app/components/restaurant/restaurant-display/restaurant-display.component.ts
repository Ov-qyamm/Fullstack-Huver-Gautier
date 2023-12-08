import {Component, Input} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {EvaluationFinaleDto, RestaurantDto} from "../../../models/dto/restaurant.dto";
import {ColorRestaurant } from '../../../directives/color-restaurant';
import {Router} from "@angular/router";

@Component({
  selector: 'app-restaurant-display',
  standalone: true,
    imports: [CommonModule, NgOptimizedImage, ColorRestaurant],
  templateUrl: './restaurant-display.component.html',
  styleUrl: './restaurant-display.component.css'
})
export class RestaurantDisplayComponent {

  @Input() restaurants: RestaurantDto[] = [];

  public evaluationFinal?: EvaluationFinaleDto;
  constructor(private router: Router) {
  }

  public DetailRestaurant(restaurant: RestaurantDto): void {
    this.router.navigate([`/restaurants/${restaurant.id}`])
  }

}
