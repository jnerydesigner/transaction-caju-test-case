package br.com.jandernery.transaction_caju.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1l;

    @Column(nullable = false)
    private double amount;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<TransactionEntity> transaction = new HashSet<>();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
}
