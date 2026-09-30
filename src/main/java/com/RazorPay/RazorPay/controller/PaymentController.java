package com.RazorPay.RazorPay.controller;


import com.RazorPay.RazorPay.service.RazorpayService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    @Autowired
    private RazorpayService razorPayService;

//    step 3 : javascript file ke paynow pr click krna par yeh create-order method order.id create kar rha ha jiski logic service meh add ki ha
  //step 3.3  localhost:808o par ope karo aur right -side broser ke yah more tools - developer tools ke option hoga
// fir network ke yah testing krnaa ,whaoar wallet select krna mobikniwk yah kuch bhi fir  success@razorpay.com
//    daalkar koi bhi opt 6 digit ka daal do
//    hogaya testing
    @PostMapping("/create-order")
    public String createOrder(@RequestParam int amount,@RequestParam String currency ) throws RazorpayException {

        return razorPayService.createOrder(amount,  currency,"recepient_100");
   }
}
