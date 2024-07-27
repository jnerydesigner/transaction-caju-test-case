package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.application.dto.AccountDepositRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountResponseDepositDTO;
import br.com.jandernery.transaction_caju.domain.entities.AccountEntity;
import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.repository.AccountRepository;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    public void openAccount(AccountRequestDTO accountRequest){
        UserModel userModel = userRepository.findById(accountRequest.userId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));


        BigDecimal decimal = new BigDecimal(0);
        AccountModel accountModel = new AccountModel();

        accountModel.setAmount(decimal);
        accountModel.setUser(userModel);


        AccountModel account = accountRepository.save(accountModel);
    }

    public AccountEntity deposit(AccountDepositRequestDTO depositRequest){
        System.out.println(depositRequest.amountDeposit());
        UserModel userModel = userRepository.findById(depositRequest.userId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        AccountModel accountModel = accountRepository.findByUserIdAndId(depositRequest.userId(), depositRequest.accountId());

        BigDecimal newAmountDeposit = accountModel.getAmount().add(depositRequest.amountDeposit());

        accountModel.setAmount(newAmountDeposit);

        accountRepository.save(accountModel);

        ModelMapper modelMapper = new ModelMapper();
        AccountEntity accountResponseDeposit = modelMapper.map(accountModel, AccountEntity.class);

        return accountResponseDeposit;
    }
}
