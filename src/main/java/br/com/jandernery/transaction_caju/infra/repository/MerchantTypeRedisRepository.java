package br.com.jandernery.transaction_caju.infra.repository;


import br.com.jandernery.transaction_caju.domain.model.MerchantTypeRedisModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MerchantTypeRedisRepository extends CrudRepository<MerchantTypeRedisModel, String> {
    List<MerchantTypeRedisModel> findByMerchantContaining(String keywords);
}
