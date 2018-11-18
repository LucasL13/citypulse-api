import { Component, OnInit, Input } from '@angular/core';
import { Globals } from '../globals';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {

  @Input() name: string;

  constructor(private globals: Globals)  {
    console.log("[navbar] J'ai modifié. Nouvelle valeur : " + this.globals.pageHeaderTitle); 
  }

  ngOnInit() {
    console.log("Je suis crée ! ");
  }

  ngOnChanges(){
    console.log("Il y a eu changement");
  }

}
