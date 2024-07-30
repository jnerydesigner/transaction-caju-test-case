package br.com.jandernery.transaction_caju.application.response;

public enum ErrorCajuResponse {
    APPROVED("00"),
    INSUFFICIENT_BALANCE("51"),
    OTHER_ERROR("07");

    private final String code;

    ErrorCajuResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
