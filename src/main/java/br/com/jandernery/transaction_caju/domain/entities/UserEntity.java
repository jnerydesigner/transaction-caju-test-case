package br.com.jandernery.transaction_caju.domain.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<TransactionEntity> transaction = new HashSet<>();


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

    public Set<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
}
