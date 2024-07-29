package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.AccountDepositRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountRequestDTO;
import br.com.jandernery.transaction_caju.application.services.AccountService;
import br.com.jandernery.transaction_caju.domain.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/find-account/{accountId}")
    public AccountMapper findAccount(@PathVariable("accountId") Long accountId){
        AccountMapper account = accountService.findAccount(accountId);

        return account;
    }

    @PatchMapping("/deposit")
    public AccountMapper deposit(@RequestBody AccountDepositRequestDTO depositRequestDTO){
        return accountService.deposit(depositRequestDTO);
    }

    @PostMapping
    public ResponseEntity<Void> openAccount(@RequestBody AccountRequestDTO accountRequest){
        accountService.openAccount(accountRequest);

        return ResponseEntity.ok().build();
    }
}
