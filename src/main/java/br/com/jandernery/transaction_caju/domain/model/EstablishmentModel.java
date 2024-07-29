package br.com.jandernery.transaction_caju.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ESTABLISHMENT")
public class EstablishmentModel extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String merchant;

    @Column
    private String mcc;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "establishment", fetch = FetchType.EAGER)
    private Set<TransactionModel> transaction = new HashSet<>();

    public EstablishmentModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<TransactionModel> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionModel> transaction) {
        this.transaction = transaction;
    }
}
