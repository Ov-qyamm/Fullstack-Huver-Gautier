import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appColorRestaurant]',
  standalone: true
})
export class ColorRestaurant {

  @Input()
  set appColorRestaurant(value: string) {
    if(parseInt(value) < 2 && parseInt(value)> 1|| parseInt(value) == -1){
        this.renderer.setStyle(this.elRef.nativeElement, "color", "black");
    }else if(parseInt(value) >= 2 ){
      this.renderer.setStyle(this.elRef.nativeElement, "color", "#FDCC0D");
    }if (parseInt(value) < 1 && parseInt(value)>= 0) {
        this.renderer.setStyle(this.elRef.nativeElement, "color", "red");
      } 
  }

  constructor(private elRef: ElementRef, private renderer: Renderer2) {
  }

}
