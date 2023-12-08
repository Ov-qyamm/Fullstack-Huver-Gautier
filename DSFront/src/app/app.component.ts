import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { RestaurantComponent } from './components/restaurant/restaurant.component';
import { RestaurentDetailComponent } from './components/restaurant-detail/restaurant-detail.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RestaurantComponent, RestaurentDetailComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'DS-Front';
}
