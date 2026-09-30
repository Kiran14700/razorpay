package com.RazorPay.RazorPay.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

//    step 2:  fir yahpar value annotation ki help se in variabless meh lele api's
    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    //step 2.1 create Order method meh amount,recieptid,currency  ki details lega
    // razorpayClient method ha razorpay ka
    public String createOrder(int amount, String currency, String receiptid) throws RazorpayException {
        RazorpayClient razorpayClient=new RazorpayClient(apiKey,apiSecret);

        //step 2.2 jo bhi data hoga ham JSONObject meh lengeh
        JSONObject orderRequest=new JSONObject();
        orderRequest.put("amount",amount);
        orderRequest.put("currency",currency);
        orderRequest.put("receipt",receiptid);

        //step 2.3 Order method se data string meh return karengeh
        //step 2.4 actually hamne javascript file banayi jahapar pay now button click krne par
//         javascript create order method jo ki hamne controller meh banaya ha use fchet krtah ha

        //step 3..1  yahpar data anepar RazorpayClient order create kar rha ha is method RazorpayClient ki help se
        //step 3.2 aur yeh data hamne javascript eh manually amount set ki ha receiptid nahi arahi wah se
        // sibh amount aur currecny hamne INR set ki ha isliya rupees ka symbol dikh rha ha
        Order order= razorpayClient.orders.create(orderRequest);
        return  order.toString();
    }
}
