package br.com.jandernery.transaction_caju.domain.mappers.projection;

import java.math.BigDecimal;

public interface UserResponseProjection {
    Long getUserId();
    Long getAccountId();
    String getName();
    String getUserName();
    BigDecimal getAmount();
    Long getAccountTypeId();
    BigDecimal getAmountType();
    String getTypeBalance();
}
