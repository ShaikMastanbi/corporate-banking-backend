package com.corporateclient.dto;

public class DeleteCorporateClientResponse {

    private String status;
    private String message;
    private int code;

    // Constructor
    public DeleteCorporateClientResponse(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
}
