import { Component, OnInit } from '@angular/core';
import { Globals } from '../globals';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

var maxEntries:number = 10;

@Component({
  selector: 'app-data-all',
  templateUrl: './data-all.component.html',
  styleUrls: ['./data-all.component.css']
})

@Injectable()
export class DataAllComponent implements OnInit {

  rawData = {};

  constructor(private globals: Globals, private http: HttpClient) { }

  ngOnInit() {
    this.globals.pageHeaderTitle = 'Visualisation of raw GPS Data';
    this.globals.pageHeaderSubtitle = 'Here you can have a look on detailled, raw-formatted data coming from the API server.';
    this.getDataFromAPI();
  }

  getDataFromAPI() : any{
    this.http.get(`164.132.51.109:9999/searchFor/test`).pipe(
      map((response: Response) => {
        this.rawData = response;
      }))
      .subscribe();
  }  

}
