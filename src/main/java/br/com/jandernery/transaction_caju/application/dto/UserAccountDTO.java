package br.com.jandernery.transaction_caju.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;



public class UserAccountDTO {
    private Long userId;
    private String userName;
    private String userUsername;
    private Long accountId;
    private BigDecimal accountAmount;
    private Long accountUserId;

    public UserAccountDTO(Long userId, String userName, String userUsername, Long accountId, BigDecimal accountAmount, Long accountUserId) {
        this.userId = userId;
        this.userName = userName;
        this.userUsername = userUsername;
        this.accountId = accountId;
        this.accountAmount = accountAmount;
        this.accountUserId = accountUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Long getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(Long accountUserId) {
        this.accountUserId = accountUserId;
    }
}
