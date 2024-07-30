package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.PayloadRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.ResponseOperationDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionPayloadDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionRecord;
import br.com.jandernery.transaction_caju.application.services.TransactionService;
import br.com.jandernery.transaction_caju.domain.mappers.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @GetMapping
    public String getHelloTransaction(){
        return "Hello Transaction";
    }

    @PostMapping
    public ResponseEntity<ResponseOperationDTO> transactionCreate(@RequestBody TransactionRecord payload) {
        ResponseOperationDTO transactionMapper = transactionService.createTransaction(payload);

        return ResponseEntity.ok(transactionMapper);
    }
}
