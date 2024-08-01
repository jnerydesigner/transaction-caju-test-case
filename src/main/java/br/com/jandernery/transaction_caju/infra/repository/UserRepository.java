package br.com.jandernery.transaction_caju.infra.repository;

import br.com.jandernery.transaction_caju.domain.mappers.projection.UserResponseProjection;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {



    @Query(value = "SELECT * FROM tb_user tu WHERE tu.user_name = ?1", nativeQuery = true)
    UserModel findByUserName(String userName);

    @Query(value = "select \n" +
            "tu.id as user_id, \n" +
            "ta.id as account_id, \n" +
            "tu.name, \n" +
            "tu.user_name, \n" +
            "ta.amount, \n" +
            "tta.id as account_type_id,\n" +
            "tta.amount as amount_type,\n" +
            "tta.type_balance as type_balance \n" +
            "from tb_user tu\n" +
            "left join tb_account ta on tu.id = ta.user_id\n" +
            "left join tb_type_account tta on tta.account_id = ta.id\n" +
            "where user_id = ?1", nativeQuery = true)
    List<UserResponseProjection> findByUserIdComplete(Long userId);
}
