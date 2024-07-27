package br.com.jandernery.transaction_caju.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1l;

    @Column(nullable = false)
    private double amount;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

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
}
