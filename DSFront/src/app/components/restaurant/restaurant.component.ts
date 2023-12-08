import {Component, OnInit} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {RestaurantService} from "../../services/restaurant.service";
import {RestaurantDto} from "../../models/dto/restaurant.dto";
import {RestaurantDisplayComponent} from "./restaurant-display/restaurant-display.component";
import {AddRestaurantFormComponent,AddRestaurantFormData } from './add-restaurant-form/add-restaurant-form.component';
import {ResearchRestaurantFormComponent } from './research-restaurant-form/research-restaurant-form.component';

@Component({
    selector: 'app-restaurant',
    standalone: true,
    templateUrl: './restaurant.component.html',
    styleUrl: './restaurant.component.css',
    imports: [CommonModule, NgOptimizedImage, RestaurantDisplayComponent, AddRestaurantFormComponent, ResearchRestaurantFormComponent]
})
export class RestaurantComponent implements OnInit {

  public restaurants: RestaurantDto[] = [];

  constructor(private readonly restaurantService: RestaurantService) {
  }

  ngOnInit(): void {
    this.refreshRestaurants();
  }

  public refreshRestaurants() {
    this.restaurantService.loadRestaurants().subscribe(value => {
      this.restaurants = value;
    })
  }

  public onRestaurantSubmitted(newRestaurantData: AddRestaurantFormData): void {
    this.restaurantService.addRestaurant(newRestaurantData).subscribe(value => {
      this.restaurants.push(value);
    })
    this.refreshRestaurants()
  }


}
