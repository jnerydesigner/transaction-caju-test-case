package br.com.jandernery.transaction_caju.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "TB_TRANSACTION")
public class TransactionEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1l;



    @Column
    private String mcc;

    @Column
    private double totalAmount;

    @Column
    private String typeBalance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private EstablishmentEntity establishment;

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public EstablishmentEntity getEstablishment() {
        return establishment;
    }

    public void setEstablishment(EstablishmentEntity establishment) {
        this.establishment = establishment;
    }
}
