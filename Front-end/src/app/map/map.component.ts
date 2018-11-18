import { Component, OnInit } from '@angular/core';
import { Globals } from '../globals';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import * as $ from 'jquery';
import * as L from 'leaflet';
import 'leaflet.markercluster';

var maxEntries: number = 2000;
var mapPoints;
const myIcon = L.icon({ iconSize: [75, 75], iconUrl: 'https://cdn0.iconfinder.com/data/icons/travel-vacation/289/travel-transport-hotel-vacation-holidays-tourist-tourism-travelling-traveling_164-512.png' });

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})

@Injectable()
export class MapComponent implements OnInit {

  rawData = {};

  constructor(private globals: Globals, private http: HttpClient) { }

  ngOnInit() {

    this.globals.pageHeaderTitle = 'Map : A visualisation of GPS Data';
    this.globals.pageHeaderSubtitle = 'Here you can see the real-world emplacement of GPS points delivered by the API.';

    mapPoints = L.map('frugalmap').setView([56.15300, 10.2049], 12);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'WoT Iee Map'
    }).addTo(mapPoints);

    this.getDataFromAPI();
  }

  getDataFromAPI(): any {
    this.http.post(`0.0.0.0:9999/searchFor/mapdata`, { "parameters": { "maxEntries": 100 } }).pipe(
      map((response: Response) => {
        this.rawData = response;
        var coordinates = response['results']['bindings'];
        console.log("COORDINATES : " + JSON.stringify(coordinates));
        var markers: any = L.markerClusterGroup();

        var bbb = 0;
        for (var k in coordinates) {
          markers.addLayer(L.marker([coordinates[k].latitude.value, coordinates[k].longitude.value], { icon: myIcon }));
          bbb += 1;
        }
        console.log("J'ai exactement : " + bbb);
        mapPoints.addLayer(markers);
      }))
      .subscribe();
  }

}
