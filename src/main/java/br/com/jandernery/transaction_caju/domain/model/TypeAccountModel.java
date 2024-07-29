package br.com.jandernery.transaction_caju.domain.model;


import br.com.jandernery.transaction_caju.application.enums.BalanceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_TYPE_ACCOUNT")
public class TypeAccountModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private String typeBalance;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AccountModel account;


    public TypeAccountModel(){}
    public TypeAccountModel(String mcc) {
        this.typeBalance = BalanceType.fromMcc(mcc).toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeBalance() {
        return typeBalance;
    }

    public void setTypeBalance(String typeBalance) {
        this.typeBalance = typeBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }


}
