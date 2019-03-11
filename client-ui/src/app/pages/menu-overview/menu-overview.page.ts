import { Component, OnDestroy, OnInit } from '@angular/core';
import { MenuService } from '../../services/menu.service';
import { IMenuItem, MenuItem } from '../../services/menu.model';
import { Subscription } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { StateService } from '../../services/state.service';

@Component({
    selector: 'dig-menu-overview',
    templateUrl: './menu-overview.page.html',
    styleUrls: ['./menu-overview.page.scss'],
})
export class MenuOverviewPage implements OnInit, OnDestroy {

    private sub = new Subscription();
    private codeValue: string;

    private menuItems: MenuItem[];
    private selectedItems: MenuItem[] = new Array();

    constructor(
        private menuSvc: MenuService,
        private activeRoute: ActivatedRoute,
        private state: StateService,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.sub.add(this.activeRoute.params.subscribe(p => {
            this.codeValue = p['codeValue'];
            console.log(this.codeValue);

            this.sub.add(
                this.menuSvc.loadMenu(this.codeValue)
                    .pipe(
                        map(v => this.menuItems = v.items),
                        tap(v => console.log(v))
                    )
                    .subscribe(v => this.menuItems = v));
        }));

    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    nextClicked() {
        this.router.navigateByUrl('/order');
    }
}
