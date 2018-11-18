import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ChartComponent } from './chart/chart.component';

import { ChartsModule } from 'ng2-charts';
import { MapComponent } from './map/map.component';
import { DataMapComponent } from './data-map/data-map.component';
import { FooterComponent } from './footer/footer.component';
import { PageHomeComponent } from './page-home/page-home.component';

import { Globals } from './globals';
import { DataAllComponent } from './data-all/data-all.component';
import { DataChartsComponent } from './data-charts/data-charts.component';

import { NgxJsonViewerModule } from 'ngx-json-viewer';
import { PageChartsComponent } from './page-charts/page-charts.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ChartComponent,
    MapComponent,
    DataMapComponent,
    FooterComponent,
    PageHomeComponent,
    DataAllComponent,
    DataChartsComponent,
    PageChartsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ChartsModule,
    NgxJsonViewerModule
  ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule { }
