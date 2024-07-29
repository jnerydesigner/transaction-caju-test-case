package br.com.jandernery.transaction_caju.infra.repository;

import br.com.jandernery.transaction_caju.application.dto.UserAccountDTO;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {



    @Query(value = "SELECT * FROM tb_user tu WHERE tu.user_name = ?1", nativeQuery = true)
    UserModel findByUserName(String userName);
}
