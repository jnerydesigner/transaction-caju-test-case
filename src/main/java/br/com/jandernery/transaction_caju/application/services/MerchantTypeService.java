package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.application.dto.MerchantTypeRequest;
import br.com.jandernery.transaction_caju.domain.model.MccSpecialityMerchantModel;
import br.com.jandernery.transaction_caju.domain.model.MerchantTypeRedisModel;
import br.com.jandernery.transaction_caju.infra.configuration.RedisConfig;
import br.com.jandernery.transaction_caju.infra.repository.MccSpecialityMerchantRepository;
import br.com.jandernery.transaction_caju.infra.repository.MerchantTypeRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

@Service
public class MerchantTypeService {



    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisConfig redisConfig;

    @Autowired
    MccSpecialityMerchantRepository mccSpecialityMerchantRepository;

    private final MerchantTypeRedisRepository merchantTypeRedisRepository;

    public MerchantTypeService(Jedis jedis, MerchantTypeRedisRepository merchantTypeRedisRepository) {
        this.merchantTypeRedisRepository = merchantTypeRedisRepository;
    }

    private static final String KEYWORD = "EATS";
    private static final String MCC_CODE = "5412";

    private static final String KEY = "Merchant:c69ac159-be3b-4739-8f2f-ff11a1b9f27c";


    public void createMerchantType(MerchantTypeRequest request){
        redisClearDatabase();
        Iterable<MerchantTypeRedisModel> iterable = merchantTypeRedisRepository.findAll();
        List<MerchantTypeRedisModel> merchantTypeAllList = StreamSupport.stream(iterable.spliterator(), false)
                        .toList();

        Iterable<MccSpecialityMerchantModel> mccSpecialistItr = mccSpecialityMerchantRepository.findAll();
        List<MccSpecialityMerchantModel> mccSpecialistList = StreamSupport.stream(mccSpecialistItr.spliterator(), false).toList();

        for(MccSpecialityMerchantModel mccSpecialityMerchant : mccSpecialistList){
            for (MerchantTypeRedisModel merchantType : merchantTypeAllList) {
                boolean toCheck = containsWord(merchantType.getMerchant(), mccSpecialityMerchant.getSpeciality());
                if(toCheck){
                    merchantType.setMcc(mccSpecialityMerchant.getMcc());
                    merchantTypeRedisRepository.save(merchantType);
                }
            }
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
        boolean merchantBoolean =  pattern.matcher(merchantDescription).find();
        System.out.println(merchantBoolean);

        return merchantBoolean;
    }


    public void findByName(String key){
        String value = redisConfig.jedisConnection().get(key);
        System.out.println(value);

    }


    public void redisClearDatabase(){
        Jedis jedis = new Jedis("localhost", 16379);
        jedis.flushDB();
        System.out.println("Número de chaves após flushDB: " + jedis.dbSize());
        jedis.close();

    }
}
