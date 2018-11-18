import { Component, OnInit } from '@angular/core';
import { Globals } from '../globals';

import * as $ from 'jquery';

var maxEntries:number = 34000;

@Component({
  selector: 'app-data-map',
  templateUrl: './data-map.component.html',
  styleUrls: ['./data-map.component.css']
})

export class DataMapComponent implements OnInit {

  rawGPSRowNames = [];
  rawGPSData = [];

  constructor(private globals: Globals) { }

  ngOnInit() {
    this.globals.pageHeaderTitle = 'Visualisation of raw GPS Data';
    this.globals.pageHeaderSubtitle = 'Here you can have a look on detailled, raw-formatted data coming from the API server.';
    this.sendAjaxRequest(this.rawGPSData);
  }

  sendAjaxRequest(data) : any{
    console.log('jenvoi request');
    $.ajax({
      type: 'POST',
      url:'http://localhost:9999/searchFor/coordinates',
      dataType : 'json',
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({'parameters': {
        'maxEntries': maxEntries
      }}),
      success: function(msg){},
      complete : function(resultat, statut){
        console.log(JSON.stringify(resultat));
        var coordinates = $.parseJSON(resultat.responseText);
        coordinates = coordinates.results.bindings;

        var head = $.parseJSON(resultat.responseText);
        console.log("A ? : " + head.head.vars);

        for(var k in coordinates) {
          data.push({'point':coordinates[k].point.value,'name':coordinates[k].name.value, 'latitude':coordinates[k].latitude.value, 'longitude':coordinates[k].longitude.value});
        }

        console.log(data.length);
      } 
    });
  }  

}
