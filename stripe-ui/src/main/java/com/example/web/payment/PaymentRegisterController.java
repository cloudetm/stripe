package com.example.web.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment/register")
public class PaymentRegisterController {

    @PostMapping("/")
    String register(){
        System.out.println("HOGE");
        return "payment/complete";
    }
}
