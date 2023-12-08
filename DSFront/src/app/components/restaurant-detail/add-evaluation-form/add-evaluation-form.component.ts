import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";

@Component({
  selector: 'app-add-evaluation-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './add-evaluation-form.component.html',
  styleUrl: './add-evaluation-form.component.css'
})
export class AddEvaluationFormComponent {

  @Output("evaluationSubmitted") evaluationSubmittedEmiter = new EventEmitter<AddEvaluationFormData>();

  public formData: AddEvaluationFormData = {
    pseudo: "",
    texte: "",
    note: 0
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.evaluationSubmittedEmiter.emit(this.formData);
    }
  }

}

export interface AddEvaluationFormData {
  pseudo: string
  texte: string
  note:number
}
