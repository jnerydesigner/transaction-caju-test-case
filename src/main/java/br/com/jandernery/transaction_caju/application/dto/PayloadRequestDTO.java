package br.com.jandernery.transaction_caju.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayloadRequestDTO {
    String account;
    float totalAmount;
    String mcc;
    String merchant;
}
