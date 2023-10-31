import { Component, signal } from '@angular/core';
import { MenuItem } from './menu-item/menu.item';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  itensMenu = signal<MenuItem[]>([
    {
      title: 'User',
      icon: ['fas', 'user'],
      subMenus: [
        {
          title: 'User List',
          icon: ['fas', 'user-group'],
          routerLink: '/user',
        },
        {
          title: 'User Form',
          icon: ['fas', 'user-edit'],
          routerLink: '/user/new',
        },
      ],
    },
  ]);
}
