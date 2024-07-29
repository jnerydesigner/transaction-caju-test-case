package br.com.jandernery.transaction_caju.presenters;


import br.com.jandernery.transaction_caju.application.dto.EstablishmentRecordDTO;
import br.com.jandernery.transaction_caju.application.dto.MerchantRequestDTO;
import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import br.com.jandernery.transaction_caju.application.services.EstablishmentService;
import br.com.jandernery.transaction_caju.domain.model.EstablishmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("establishment")
public class EstablishmentController {

    @Autowired
    EstablishmentService establishmentService;

    @PostMapping
    public void createEstablishment(@RequestBody EstablishmentRecordDTO establishmentBody){
        establishmentService.createEstablishment(establishmentBody);
    }

    @PostMapping("/find-merchant")
    public EstablishmentModel findMerchant(@RequestBody MerchantRequestDTO merchantRequestDTO){
        EstablishmentModel establishmentModel = establishmentService.findEstablishmentByName(merchantRequestDTO.merchant());

        return establishmentModel;
    }
}
