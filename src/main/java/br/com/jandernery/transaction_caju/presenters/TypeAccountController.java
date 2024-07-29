package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.domain.model.TypeAccountModel;
import br.com.jandernery.transaction_caju.infra.repository.TypeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type_account")
public class TypeAccountController {

    @Autowired
    TypeAccountRepository typeAccountRepository;

    @GetMapping("/{account_id}")
    public ResponseEntity<List<TypeAccountModel>> findTypeAccountWithAccountId(@PathVariable("account_id") String accountId){
        Long accountIdNumber = Long.parseLong(accountId);

        List<TypeAccountModel> typeAccountModels = typeAccountRepository.findByAccountId(accountIdNumber);

        return ResponseEntity.ok(typeAccountModels);

    }
}
