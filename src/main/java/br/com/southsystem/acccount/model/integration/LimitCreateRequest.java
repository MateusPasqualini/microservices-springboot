package br.com.southsystem.acccount.model.integration;

public class LimitCreateRequest {
    private String idAccount;

    public LimitCreateRequest(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
