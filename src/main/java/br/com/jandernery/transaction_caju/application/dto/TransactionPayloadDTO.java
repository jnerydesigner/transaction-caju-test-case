package br.com.jandernery.transaction_caju.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

public record TransactionPayloadDTO(String account, DecimalFormat totalAmount, String mcc, String merchant) {
}
