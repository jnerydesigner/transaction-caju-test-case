package br.com.jandernery.transaction_caju.domain.entities;


import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TB_USER")
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1l;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String userName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AccountEntity account;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
