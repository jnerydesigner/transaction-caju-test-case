package br.com.jandernery.transaction_caju.application.dto;

public class MerchantTypeRequest {
    private String merchant;

    private String typeBusiness;

    private String mcc;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTypeBusiness() {
        return typeBusiness;
    }

    public void setTypeBusiness(String typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }
}
