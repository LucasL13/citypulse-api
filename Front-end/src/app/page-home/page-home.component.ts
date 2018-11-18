import { Component, OnInit } from '@angular/core';
import { Globals } from '../globals';

@Component({
  selector: 'app-page-home',
  templateUrl: './page-home.component.html',
  styleUrls: ['./page-home.component.css']
})
export class PageHomeComponent implements OnInit {

  constructor(private globals: Globals) { }

  ngOnInit() {
    this.globals.pageHeaderTitle = 'TP WoT';
    this.globals.pageHeaderSubtitle = 'Front-end service for my API based on iot.ee.surrey.ac.uk/citypulse/ data.';
  }

}
