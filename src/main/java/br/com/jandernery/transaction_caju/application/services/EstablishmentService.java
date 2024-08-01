package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.application.dto.EstablishmentRecordDTO;
import br.com.jandernery.transaction_caju.domain.model.EstablishmentModel;
import br.com.jandernery.transaction_caju.infra.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstablishmentService {

    @Autowired
    EstablishmentRepository establishmentRepository;
    public void createEstablishment(EstablishmentRecordDTO establishmentInput){
        EstablishmentModel establishmentModel = new EstablishmentModel();
        establishmentModel.setMcc(establishmentInput.mcc());
        establishmentModel.setMerchant(establishmentInput.merchant());


        establishmentRepository.save(establishmentModel);
    }

    public EstablishmentModel findEstablishmentByName(String merchant){
        EstablishmentModel establishmentModel = establishmentRepository.findEstablishmentByName(merchant);

        return establishmentModel;
    }

    public List<EstablishmentModel> findAll(){
        List<EstablishmentModel> establishmentModels = establishmentRepository.findAll();

        return establishmentModels;
    }
}
