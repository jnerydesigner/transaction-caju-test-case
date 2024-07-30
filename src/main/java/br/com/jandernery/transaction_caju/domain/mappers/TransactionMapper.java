package br.com.jandernery.transaction_caju.domain.mappers;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionMapper {
    Long account;
    BigDecimal totalAmount;
    String mcc;
    String merchant;
}
