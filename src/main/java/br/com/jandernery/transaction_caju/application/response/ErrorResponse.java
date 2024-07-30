package br.com.jandernery.transaction_caju.application.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
public class ErrorResponse {
    private String code;

    public ErrorResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
