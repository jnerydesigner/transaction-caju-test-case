package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.PayloadRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.ResponseOperationDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionPayloadDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionRecord;
import br.com.jandernery.transaction_caju.application.services.ReadAndIncludeTypesInMcc;
import br.com.jandernery.transaction_caju.application.services.TransactionService;
import br.com.jandernery.transaction_caju.domain.mappers.TransactionMapper;
import br.com.jandernery.transaction_caju.domain.model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("transaction")
@CrossOrigin(origins = "http://localhost:3333")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ReadAndIncludeTypesInMcc readAndIncludeTypesInMcc;

    @GetMapping
    public String getHelloTransaction() throws IOException {
        readAndIncludeTypesInMcc.readFile();
        return "Hello Transaction";
    }

    @PostMapping
    public ResponseEntity<ResponseOperationDTO> transactionCreate(@RequestBody TransactionRecord payload) {
        ResponseOperationDTO transactionMapper = transactionService.createTransaction(payload);

        return ResponseEntity.ok(transactionMapper);
    }

    @GetMapping("/paginate")
    public List<TransactionModel> getTransactions(){
        return transactionService.getAllTransactionsOrderByCreatedAt();
    }

}
