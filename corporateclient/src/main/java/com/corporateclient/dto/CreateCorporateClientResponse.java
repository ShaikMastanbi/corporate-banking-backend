package com.corporateclient.dto;

import com.corporateclient.entity.CorporateClient;

public class CreateCorporateClientResponse {

    private String status;
    private String message;
    private int code;
    private CorporateClient corporateClient;

    // Constructor
    public CreateCorporateClientResponse(String status, String message, int code, CorporateClient corporateClient) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.corporateClient = corporateClient;
    }

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public CorporateClient getCorporateClient() { return corporateClient; }
    public void setCorporateClient(CorporateClient corporateClient) { this.corporateClient = corporateClient; }
}
