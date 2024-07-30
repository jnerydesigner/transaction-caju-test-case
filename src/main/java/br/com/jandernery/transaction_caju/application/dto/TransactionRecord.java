package br.com.jandernery.transaction_caju.application.dto;

import java.math.BigDecimal;

public record TransactionRecord(String account, BigDecimal amount, String mcc, String merchant) {

}
