package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.PayloadRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionPayloadDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @GetMapping
    public String getHelloTransaction(){
        return "Hello Transaction";
    }

    @PostMapping
    public PayloadRequestDTO transactionCreate(@RequestBody PayloadRequestDTO payload) {
        return payload;
    }
}
