package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.application.dto.AccountDepositRequestDTO;
import br.com.jandernery.transaction_caju.application.dto.AccountRequestDTO;
import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import br.com.jandernery.transaction_caju.domain.mappers.AccountMapper;
import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import br.com.jandernery.transaction_caju.domain.model.TypeAccountModel;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.repository.AccountRepository;
import br.com.jandernery.transaction_caju.infra.repository.TypeAccountRepository;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeAccountRepository typeAccountRepository;

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

        TypeAccountModel typeOne = new TypeAccountModel("5411");
        typeOne.setAmount(decimal);
        typeOne.setAccount(account);

        TypeAccountModel typeTwo = new TypeAccountModel("5811");
        typeTwo.setAmount(decimal);
        typeTwo.setAccount(account);

        TypeAccountModel typeThree = new TypeAccountModel("6000");
        typeThree.setAmount(decimal);
        typeThree.setAccount(account);



        typeAccountRepository.save(typeOne);
        typeAccountRepository.save(typeTwo);
        typeAccountRepository.save(typeThree);
    }

    public AccountMapper deposit(AccountDepositRequestDTO depositRequest){
        System.out.println(depositRequest.amountDeposit());
        UserModel userModel = userRepository.findById(depositRequest.userId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        AccountModel accountModel = accountRepository.findByUserIdAndId(depositRequest.userId(), depositRequest.accountId());

        BigDecimal newAmountDeposit = accountModel.getAmount().add(depositRequest.amountDeposit());

        accountModel.setAmount(newAmountDeposit);

        accountRepository.save(accountModel);

        ModelMapper modelMapper = new ModelMapper();
        AccountMapper accountResponseDeposit = modelMapper.map(accountModel, AccountMapper.class);

        return accountResponseDeposit;
    }

    public AccountMapper findAccount(Long accountId) {
        AccountModel accountModel = accountRepository.findById(accountId).orElseThrow(() -> new NoSuchElementException("Account not found"));
        List<TypeAccountModel> typeAccountModelList = typeAccountRepository.findByAccountId(accountModel.getId());
        Set<TypeAccountModel> typeAccountModelSet = new HashSet<>(typeAccountModelList);
        accountModel.setTypeAccountModel(typeAccountModelSet);
        ModelMapper modelMapper = new ModelMapper();
        AccountMapper accountResponse = modelMapper.map(accountModel, AccountMapper.class);

        return accountResponse;
    }
}
