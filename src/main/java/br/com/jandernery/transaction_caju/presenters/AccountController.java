package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.AccountDepositRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountResponseDepositDTO;
import br.com.jandernery.transaction_caju.application.services.AccountService;
import br.com.jandernery.transaction_caju.domain.entities.AccountEntity;
import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PatchMapping("/deposit")
    public AccountEntity deposit(@RequestBody AccountDepositRequestDTO depositRequestDTO){
        return accountService.deposit(depositRequestDTO);
    }

    @PostMapping
    public void openAccount(@RequestBody AccountRequestDTO accountRequest){
        accountService.openAccount(accountRequest);
    }
}
