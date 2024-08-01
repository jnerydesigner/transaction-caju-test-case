package br.com.jandernery.transaction_caju.infra.repository;


import br.com.jandernery.transaction_caju.domain.model.MccSpecialityMerchantModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MccSpecialityMerchantRepository extends CrudRepository<MccSpecialityMerchantModel, String> {
}
