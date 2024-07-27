package br.com.jandernery.transaction_caju.domain.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ESTABLISHMENT")
public class EstablishmentEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1l;


    @Column
    private String merchant;

    @Column
    private String mcc;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "establishment", fetch = FetchType.EAGER)
    private Set<TransactionEntity> transaction = new HashSet<>();

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
}
