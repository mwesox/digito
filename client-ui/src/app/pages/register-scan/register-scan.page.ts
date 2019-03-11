import { Component, OnInit } from '@angular/core';
import { Platform } from '@ionic/angular';
import { Router } from '@angular/router';
import { BarcodeScanner } from '@ionic-native/barcode-scanner/ngx';

@Component({
    selector: 'dig-register-scan',
    templateUrl: './register-scan.page.html',
    styleUrls: ['./register-scan.page.scss'],
})
export class RegisterScanPage implements OnInit {

    private status = '';
    isFallback = false;
    codeValue: string;


    constructor(
        private barcodeScanner: BarcodeScanner,
        private platform: Platform,
        private router: Router
    ) {
    }

    ngOnInit(): void {

        this.platform.ready().then(() => {
                if (this.platform.is('cordova')) {
                    this.status = this.status.concat('....cordova detected');
                    // this.prepareQrScanner();
                } else {
                    this.isFallback = true;
                    // TODO Browser / Fallback
                    this.status = 'fallback required ' + this.platform.platforms();
                }
            }
        );
    }

    fallbackNavigate() {
        this.router.navigateByUrl('/menu-overview/' + this.codeValue)
            .catch(e => console.log(e));
    }

    scanCode() {
        console.log('Scan code');
        this.status = this.status.concat('...start scanning');

        const options = {
            prompt : 'Scan your barcode '
        };
        this.barcodeScanner.scan(options).then((barcodeData) => {

            console.info(barcodeData.text);
            this.codeValue = barcodeData.text;

            this.status = this.status.concat('...' + barcodeData.text);

            this.router.navigateByUrl('/menu-overview/' + this.codeValue)
                .catch(e => console.log(e));

        }, (err) => {
            console.info('Error occured : ' + err);
            this.status = this.status.concat('...' + err);
        });


    }


}
