import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopoComponent } from './layout/topo/topo.component';
import { RodapeComponent } from './layout/rodape/rodape.component';
import { NgHttpLoaderModule } from 'ng-http-loader';

import { LOCALE_ID } from '@angular/core';
import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
import { SharedModule } from './shared/shared.module';
import { DashboardComponent } from './layout/dashboard/dashboard.component';
import { MenuModule } from './layout/menu/menu.module';
registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    TopoComponent,
    RodapeComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgHttpLoaderModule.forRoot(),
    MenuModule,
    SharedModule,
  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: 'pt-BR',
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
