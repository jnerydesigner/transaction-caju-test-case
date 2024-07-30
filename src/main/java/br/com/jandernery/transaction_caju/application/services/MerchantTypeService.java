package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.application.dto.MerchantTypeRequest;
import br.com.jandernery.transaction_caju.domain.model.MerchantTypeRedisModel;
import br.com.jandernery.transaction_caju.infra.repository.MerchantTypeRedisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MerchantTypeService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final MerchantTypeRedisRepository merchantTypeRedisRepository;

    public MerchantTypeService(MerchantTypeRedisRepository merchantTypeRedisRepository) {
        this.merchantTypeRedisRepository = merchantTypeRedisRepository;
    }

    private static final String KEYWORD = "EATS";
    private static final String MCC_CODE = "5412";

    private static final String KEY = "Merchant:c69ac159-be3b-4739-8f2f-ff11a1b9f27c";


    public void createMerchantType(MerchantTypeRequest request){
        Iterable<MerchantTypeRedisModel> iterable = merchantTypeRedisRepository.findAll();
        List<MerchantTypeRedisModel> all = StreamSupport.stream(iterable.spliterator(), false)
                        .collect(Collectors.toList());
        for (MerchantTypeRedisModel merchant : all) {
            merchant.setMcc("5412");
            boolean padaria = containsWord(merchant.getMerchant(), "eats");
            System.out.println(padaria);
            merchantTypeRedisRepository.save(merchant);
            System.out.println(merchant.getMerchant());
        }

        MerchantTypeRedisModel merchantTypeRedisModel = new MerchantTypeRedisModel();
        merchantTypeRedisModel.setTypeBusiness(request.getTypeBusiness());
        merchantTypeRedisModel.setMcc(request.getMcc());
        merchantTypeRedisModel.setMerchant(request.getMerchant());

//        merchantTypeRedisRepository.save(merchantTypeRedisModel);
    }

    public boolean containsWord(String merchantDescription, String word) {
        if (merchantDescription == null || word == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE);
        return pattern.matcher(merchantDescription).find();
    }

}
