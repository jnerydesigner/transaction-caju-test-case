package br.com.jandernery.transaction_caju.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "TB_TRANSACTION")
public class TransactionModel extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String mcc;

    @Column
    private double totalAmount;

    @Column
    private String typeBalance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountModel account;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private EstablishmentModel establishment;

    public TransactionModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTypeBalance() {
        return typeBalance;
    }

    public void setTypeBalance(String typeBalance) {
        this.typeBalance = typeBalance;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public EstablishmentModel getEstablishment() {
        return establishment;
    }

    public void setEstablishment(EstablishmentModel establishment) {
        this.establishment = establishment;
    }
}
