package br.com.jandernery.transaction_caju.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountModel extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;


    @OneToOne
    private UserModel user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "account")
    private Set<TransactionModel> transaction = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Set<TransactionModel> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionModel> transaction) {
        this.transaction = transaction;
    }
}
