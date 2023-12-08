import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";

@Component({
  selector: 'app-research-restaurant-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './research-restaurant-form.component.html',
  styleUrl: './research-restaurant-form.component.css'
})
export class ResearchRestaurantFormComponent {

  @Output("restaurantResearchSubmitted") restaurantResearchSubmittedEmiter = new EventEmitter<ResearchRestaurantFormData>();

  public formData: ResearchRestaurantFormData = {
    titre: ""
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restaurantResearchSubmittedEmiter.emit(this.formData);
    }
  }

}

export interface ResearchRestaurantFormData {
  titre: string
}
