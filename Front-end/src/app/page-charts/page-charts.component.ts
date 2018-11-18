import { Component, OnInit } from '@angular/core';
import { Globals } from '../globals';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DataFormat } from '../dataFormat';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

@Component({
  selector: 'app-page-charts',
  templateUrl: './page-charts.component.html',
  styleUrls: ['./page-charts.component.css']
})

@Injectable({providedIn : 'root'})
export class PageChartsComponent implements OnInit {

  data:String;
  dTest = new DataFormat();
  dataTest: DataFormat[] = [new DataFormat()];
  

  constructor(private http: HttpClient, private globals: Globals) { }

  ngOnInit() {
    this.globals.pageHeaderTitle = 'Charts : A visualisation of raw Data';
    this.globals.pageHeaderSubtitle = 'Here you can see some charts displaying useful data develired by the API.';
    this.http.get(`http://localhost:9999/searchFor/test`).pipe(
      map((response: Response) => {
        console.log("ALORS ALORS : " + JSON.stringify(response));
      }))
      .subscribe();
  }
  

  getAll(): Observable<DataFormat[]>{
    return this.http.get<DataFormat[]>("0.0.0.0:9999/searchFor/test")
            .pipe(
              tap(_ => this.log("fetched data")),
              catchError(this.handleError('getHeroes', []))
            );
  }

  private handleError<T> (operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    }
  }

  private log(message: string) {
    console.log(`Message : ${message}`);
  }

}
