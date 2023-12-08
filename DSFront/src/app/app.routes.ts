import {Routes} from '@angular/router';
import {RestaurantComponent} from "./components/restaurant/restaurant.component";
import { RestaurentDetailComponent } from './components/restaurant-detail/restaurant-detail.component';

export const routes: Routes = [
  {
    path: '', component: RestaurantComponent
  },
  {
    path: 'restaurants/:id', component: RestaurentDetailComponent
  }
];
