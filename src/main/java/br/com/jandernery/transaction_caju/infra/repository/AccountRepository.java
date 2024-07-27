package br.com.jandernery.transaction_caju.infra.repository;


import br.com.jandernery.transaction_caju.domain.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    AccountModel findByUserIdAndId(Long userId, Long accountId);
}
