package com.example.web.payment;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/payment/register")
public class PaymentRegisterController {

    @Value("${stripe.api.key}")
    String apiKey;

    @PostMapping("/")
    String register(@RequestParam("stripeToken") String token){
        Stripe.apiKey = this.apiKey;

        try {
            Map<String, Object> chargeParams = new HashMap<String, Object>();
            chargeParams.put("amount", 100); // Amount in cents
            chargeParams.put("currency", "jpy");
            chargeParams.put("source", token);
            chargeParams.put("description", "Example charge");

            Charge charge = Charge.create(chargeParams);
        } catch (CardException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return "payment/complete";
    }
}
