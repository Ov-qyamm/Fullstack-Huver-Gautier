import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";

@Component({
  selector: 'app-add-restaurant-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './add-restaurant-form.component.html',
  styleUrl: './add-restaurant-form.component.css'
})
export class AddRestaurantFormComponent {

  @Output("restaurantSubmitted") restaurantSubmittedEmiter = new EventEmitter<AddRestaurantFormData>();

  public formData: AddRestaurantFormData = {
    titre: "",
    adresse: ""
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restaurantSubmittedEmiter.emit(this.formData);
    }
  }

}

export interface AddRestaurantFormData {
  titre: string
  adresse: string
}
