package br.com.jandernery.transaction_caju.infra.repository;

import br.com.jandernery.transaction_caju.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
