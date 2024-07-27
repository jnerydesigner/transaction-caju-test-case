package br.com.jandernery.transaction_caju.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity {
    public Long id;
    public double amount;
    public UserEntity user;
}
