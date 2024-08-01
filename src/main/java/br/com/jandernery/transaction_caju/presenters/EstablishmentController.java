package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.EstablishmentRecordDTO;
import br.com.jandernery.transaction_caju.application.dto.MerchantRequestDTO;
import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import br.com.jandernery.transaction_caju.application.services.EstablishmentService;
import br.com.jandernery.transaction_caju.application.services.ReadAndIncludeTypesInMcc;
import br.com.jandernery.transaction_caju.application.services.ReadXlsAndIncludeMerchant;
import br.com.jandernery.transaction_caju.domain.model.EstablishmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("establishment")
public class EstablishmentController {

    @Autowired
    EstablishmentService establishmentService;

    @Autowired
    ReadXlsAndIncludeMerchant readXlsAndIncludeMerchant;

    @PostMapping
    public void createEstablishment(@RequestBody EstablishmentRecordDTO establishmentBody){
        establishmentService.createEstablishment(establishmentBody);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EstablishmentModel>> findAll(){
        List<EstablishmentModel> establishmentModels = establishmentService.findAll();
        return ResponseEntity.ok(establishmentModels);
    }

    @PostMapping("/find-merchant")
    public EstablishmentModel findMerchant(@RequestBody MerchantRequestDTO merchantRequestDTO){
        EstablishmentModel establishmentModel = establishmentService.findEstablishmentByName(merchantRequestDTO.merchant());

        return establishmentModel;
    }

    @PostMapping("/create-merchant")
    public void createMerchant() throws IOException {
        readXlsAndIncludeMerchant.readFileAndInclude();
    }
}
