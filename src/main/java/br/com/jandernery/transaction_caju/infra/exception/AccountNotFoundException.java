package br.com.jandernery.transaction_caju.infra.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Account not found");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
