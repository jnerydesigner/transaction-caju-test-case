package br.com.jandernery.transaction_caju.domain.mappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountMapper {
    public Long id;
    public double amount;
    public AccountUserMapper user;
    public List<AccountType> accountType;
}


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class AccountUserMapper{
    public Long id;
    public String name;
    public String userName;
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class AccountType{
    public Long id;
    public String typeBalance;
    public BigDecimal amount;
}
