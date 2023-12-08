import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";

@Component({
  selector: 'app-edit-restaurant-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './edit-restaurant-form.component.html',
  styleUrl: './edit-restaurant-form.component.css'
})

export class EditRestaurantFormComponent {

  @Output("restaurantEditSubmitted") restaurantSubmittedEmiter = new EventEmitter<EditRestaurantFormData>();

  public formData: EditRestaurantFormData = {
    titre: "",
    adresse: ""
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restaurantSubmittedEmiter.emit(this.formData);
    }
  }

}

export interface EditRestaurantFormData {
  titre: string
  adresse: string
}