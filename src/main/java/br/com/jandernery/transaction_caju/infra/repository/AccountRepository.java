package br.com.jandernery.transaction_caju.infra.repository;


import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    AccountModel findByUserIdAndId(Long userId, Long accountId);




//
//    @Query("SELECT COUNT(a) > 0 FROM AccountModel a WHERE a.user.id = :userId AND a.typeAccount = :typeAccount")
//    Boolean checkUserAndMccExists(@Param("userId") Long userId, @Param("typeAccount") String typeAccount);
}
