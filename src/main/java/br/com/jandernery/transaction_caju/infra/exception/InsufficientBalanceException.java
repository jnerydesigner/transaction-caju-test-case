package br.com.jandernery.transaction_caju.infra.exception;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("Insufficient balance");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
