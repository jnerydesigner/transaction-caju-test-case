package br.com.jandernery.transaction_caju.domain.mappers;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@Getter
@Setter
public class UserResponseMapper {
    private UserMapper user;
    @Getter
    @Setter
    public static class UserMapper {
        private Long id;
        private String name;
        private String username;
        private AccountMapper account;
    }

    @Getter
    @Setter
    public static class AccountMapper {
        private Long id;
        private BigDecimal balanceAmount;
        private List<TypeMapper> type;
    }

    @Getter
    @Setter
    public static class TypeMapper {
        private Long id;
        private String balanceType;
        private BigDecimal balance;
    }

}
