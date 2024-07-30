package br.com.jandernery.transaction_caju.presenters;

import br.com.jandernery.transaction_caju.application.dto.MerchantTypeRequest;
import br.com.jandernery.transaction_caju.application.services.MerchantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchant-type")
public class MerchantTypeController {

    @Autowired
    MerchantTypeService merchantTypeService;
    @PostMapping
    public void merchantTypeCreate(@RequestBody MerchantTypeRequest request){
        merchantTypeService.createMerchantType(request);
    }
}
