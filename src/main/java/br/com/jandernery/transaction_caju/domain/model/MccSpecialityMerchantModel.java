package br.com.jandernery.transaction_caju.domain.model;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("MccSpecialityMerchant")
public class MccSpecialityMerchantModel {

    @Id
    private String id;

    private String speciality;


    private String mcc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }
}
