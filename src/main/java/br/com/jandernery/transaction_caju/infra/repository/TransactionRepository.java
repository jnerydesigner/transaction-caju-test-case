package br.com.jandernery.transaction_caju.infra.repository;

import br.com.jandernery.transaction_caju.domain.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    @Query("SELECT t FROM TransactionModel t ORDER BY t.createdAt DESC")
    List<TransactionModel> findAllOrderByCreatedAt();
}
