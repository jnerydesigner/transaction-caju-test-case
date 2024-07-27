package br.com.jandernery.transaction_caju.application.dto;

import java.math.BigDecimal;

public record AccountDepositRequestDTO(Long userId, Long accountId, BigDecimal amountDeposit) {
}
