package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.application.dto.ResponseOperationDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionRecord;
import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import br.com.jandernery.transaction_caju.application.response.ErrorCajuResponse;
import br.com.jandernery.transaction_caju.domain.mappers.TransactionMapper;
import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import br.com.jandernery.transaction_caju.domain.model.TransactionModel;
import br.com.jandernery.transaction_caju.domain.model.TypeAccountModel;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.exception.InsufficientBalanceException;
import br.com.jandernery.transaction_caju.infra.repository.AccountRepository;
import br.com.jandernery.transaction_caju.infra.repository.TypeAccountRepository;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeAccountRepository typeAccountRepository;

    public ResponseOperationDTO createTransaction(TransactionRecord transactionDto){
        Long accountIdNumber = Long.parseLong(transactionDto.account());
        AccountModel accountModel = accountRepository.findById(accountIdNumber).orElseThrow(() -> new NoSuchElementException("Account does not exists"));

        Optional<UserModel> userModel = userRepository.findById(accountModel.getUser().getId());

        TypeAccountModel typeAccountModel = typeAccountRepository.findTypeAccountByIdAndMcc(accountModel.getId(), BalanceType.fromMcc(transactionDto.mcc()).toString());


        typeAccountModel.setAmount(typeAccountModel.getAmount().add(transactionDto.amount()));

        BigDecimal result = accountModel.getAmount().subtract(transactionDto.amount());

        ResponseOperationDTO operation = new ResponseOperationDTO();

        if(result.compareTo(BigDecimal.ZERO) < 0){
            operation.setCode(ErrorCajuResponse.INSUFFICIENT_BALANCE.getCode());
            return operation;
        }

        accountModel.setAmount(result);


        typeAccountRepository.save(typeAccountModel);
        accountRepository.save(accountModel);


        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTotalAmount(transactionDto.amount());

        operation.setCode(ErrorCajuResponse.APPROVED.getCode());


        return operation;
    }
}
