package br.com.jandernery.transaction_caju.domain.model;


import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Merchant")
public class MerchantTypeRedisModel implements Serializable {

    @Id
    private String id;

    private String merchant;

    private String typeBusiness;

    private String mcc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
