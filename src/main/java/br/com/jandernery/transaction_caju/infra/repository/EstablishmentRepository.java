package br.com.jandernery.transaction_caju.infra.repository;

import br.com.jandernery.transaction_caju.domain.model.EstablishmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentModel, Long> {


    @Query(value = "SELECT * FROM tb_establishment te WHERE te.merchant = ?1", nativeQuery = true)
    EstablishmentModel findEstablishmentByName(String name);
}
