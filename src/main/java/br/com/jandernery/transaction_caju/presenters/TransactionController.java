package br.com.jandernery.transaction_caju.presenters;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @GetMapping
    public String getHelloTransaction(){
        return "Hello Transaction";
    }
}
