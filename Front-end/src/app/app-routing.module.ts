import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { ChartComponent } from './chart/chart.component';
import { MapComponent } from './map/map.component';
import { DataMapComponent } from './data-map/data-map.component';
import { DataAllComponent } from './data-all/data-all.component';
import { DataChartsComponent } from './data-charts/data-charts.component';

import { PageHomeComponent } from './page-home/page-home.component';
import { PageChartsComponent } from './page-charts/page-charts.component';

const routes: Routes = [
  {path: '', component: PageHomeComponent},
  {path: 'test', component: NavbarComponent},
  {path: 'charts', component: PageChartsComponent},
  {path: 'showmap', component: MapComponent},
  {path: 'datamap', component: DataMapComponent},
  {path: 'dataall', component: DataAllComponent},
  {path: 'datacharts', component: DataChartsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
