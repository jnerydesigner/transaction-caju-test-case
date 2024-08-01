package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.application.dto.ResponseOperationDTO;
import br.com.jandernery.transaction_caju.application.dto.TransactionRecord;
import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import br.com.jandernery.transaction_caju.application.response.ErrorCajuResponse;
import br.com.jandernery.transaction_caju.domain.mappers.TransactionMapper;
import br.com.jandernery.transaction_caju.domain.model.*;
import br.com.jandernery.transaction_caju.infra.exception.InsufficientBalanceException;
import br.com.jandernery.transaction_caju.infra.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

@Service
@Transactional
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeAccountRepository typeAccountRepository;

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public ResponseOperationDTO createTransaction(TransactionRecord transactionDto){
        System.out.println(transactionDto);
        ResponseOperationDTO operation = new ResponseOperationDTO();
        Optional<EstablishmentModel> establishmentByNameOpt = establishmentRepository.findEstablishmentByNameOpt(transactionDto.merchant());
        if(establishmentByNameOpt.isEmpty()){
            System.out.println("chegou aqui");
            operation.setCode(ErrorCajuResponse.OTHER_ERROR.getCode());
            return operation;
        }

        Long accountIdNumber = Long.parseLong(transactionDto.account());

//        Optional<AccountModel> accModel = accountRepository.findAccountId(accountIdNumber);

        AccountModel accountModel = accountRepository.findById(accountIdNumber).orElseThrow(() -> new NoSuchElementException("Account does not exists"));

        Optional<UserModel> userModel = userRepository.findById(accountModel.getUser().getId());

        TypeAccountModel typeAccountModel = typeAccountRepository.findTypeAccountByIdAndMcc(accountModel.getId(), BalanceType.fromMcc(transactionDto.mcc()).toString());


        typeAccountModel.setAmount(typeAccountModel.getAmount().add(transactionDto.amount()));

        BigDecimal result = accountModel.getAmount().subtract(transactionDto.amount());



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


        TransactionModel transactionModel1 = new TransactionModel();
        transactionModel1.setAccount(accountModel);
        transactionModel1.setEstablishment(establishmentByNameOpt.get());
        transactionModel1.setUser(userModel.get());
        transactionModel1.setMcc(establishmentByNameOpt.get().getMcc());
        transactionModel1.setTotalAmount(transactionDto.amount());
        transactionModel1.setTypeBalance(BalanceType.fromMcc(transactionDto.mcc()).toString());

        transactionRepository.save(transactionModel1);


        return operation;
    }


    public List<TransactionModel> getAllTransactionsOrderByCreatedAt() {
        return transactionRepository.findAllOrderByCreatedAt();
    }
}
