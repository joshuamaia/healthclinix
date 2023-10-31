import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [UserFormComponent, UserListComponent],
  imports: [CommonModule, UserRoutingModule, SharedModule],
})
export class UserModule {}
