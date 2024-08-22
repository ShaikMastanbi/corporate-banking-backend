package com.corporateclient.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CreditHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "corporate_client_id")
    private CorporateClient corporateClient;

    private String creditScore;
    private String creditStatus;

    public CreditHistory(Long id, CorporateClient corporateClient, String creditScore, String creditStatus) {
        this.id = id;
        this.corporateClient = corporateClient;
        this.creditScore = creditScore;
        this.creditStatus = creditStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CorporateClient getCorporateClient() {
        return corporateClient;
    }

    public void setCorporateClient(CorporateClient corporateClient) {
        this.corporateClient = corporateClient;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    @Override
    public String toString() {
        return "CreditHistory{" +
                "id=" + id +
                ", corporateClient=" + corporateClient +
                ", creditScore='" + creditScore + '\'' +
                ", creditStatus='" + creditStatus + '\'' +
                '}';
    }
}
