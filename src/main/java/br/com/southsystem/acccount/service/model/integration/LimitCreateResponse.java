package br.com.southsystem.acccount.service.model.integration;

import java.math.BigDecimal;

public class LimitCreateResponse {

    private String idLimit;
    private BigDecimal value;


    public String getIdLimit() {
        return idLimit;
    }

    public void setIdLimit(String idLimit) {
        this.idLimit = idLimit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
