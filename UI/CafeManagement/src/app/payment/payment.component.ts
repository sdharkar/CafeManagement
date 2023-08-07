import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../service/payment.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit{

  constructor(private paymentService: PaymentService){}

  ngOnInit(): void {
  }


  //payment
  options = {
    "key": "rzp_test_Ouxszjq8Ww4Jw0", // Enter the Key ID generated from the Dashboard
    "amount": "50000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "OnDeals",
    "description": "Test Transaction",
    "image": "https://example.com/your_logo",
    "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "callback_url": "https://eneqd3r9zrjok.x.pipedream.net/",
    "prefill": {
        "name": "Shrirang Dharkar",
        "email": "dharkar_shrirang.cs@ghrce.raisoni.net",
        "contact": "7378488847"
    },
    handler: function(response: any){
      Swal.fire({"title": "payment Successful",showConfirmButton: false, timer:1500});
      window.location.href="/paySuccess";
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};

rzp1:any;
pay(){
  this.options.amount= "29900";
  this.rzp1 = new this.paymentService.nativeWindow.Razorpay(this.options);
  this.rzp1.open();
}

}
