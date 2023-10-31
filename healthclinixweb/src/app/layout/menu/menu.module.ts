import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuRoutingModule } from './menu-routing.module';

import { MenuComponent } from './menu.component';
import { MenuItemComponent } from './menu-item/menu-item.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [MenuComponent, MenuItemComponent],
  imports: [CommonModule, MenuRoutingModule, SharedModule],
  exports: [MenuComponent],
})
export class MenuModule {}
