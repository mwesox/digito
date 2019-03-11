import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    {path: '', redirectTo: 'register-scan', pathMatch: 'full'},
    {path: 'menu-overview/:codeValue', loadChildren: './pages/menu-overview/menu-overview.module#MenuOverviewPageModule'},
    {path: 'register-scan', loadChildren: './pages/register-scan/register-scan.module#RegisterScanPageModule'},
    {path: 'order', loadChildren: './pages/order/order.module#OrderPageModule'}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
