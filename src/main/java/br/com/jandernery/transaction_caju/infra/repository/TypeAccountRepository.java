package br.com.jandernery.transaction_caju.infra.repository;


import br.com.jandernery.transaction_caju.domain.model.TypeAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeAccountRepository extends JpaRepository<TypeAccountModel, Long> {

    @Query(value = "select * from tb_type_account ta where ta.account_id = ?1", nativeQuery = true)
    List<TypeAccountModel> findByAccountId(Long accountId);

    @Query(value = "select * from tb_type_account ta where account_id = ?1 and ta.type_balance = ?2", nativeQuery = true)
    TypeAccountModel findTypeAccountByIdAndMcc(Long accountId, String mcc);

}
