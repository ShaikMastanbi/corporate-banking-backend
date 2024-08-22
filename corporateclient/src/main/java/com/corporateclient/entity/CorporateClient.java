package com.corporateclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class CorporateClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String address;
    private String contactEmail;
    private String contactPhone;

    @OneToMany(mappedBy = "corporateClient", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FinancialStatement> financialStatements;

    @OneToMany(mappedBy = "corporateClient", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CreditHistory> creditHistories;

    public CorporateClient(Long id, String companyName, String address, String contactEmail, String contactPhone, Set<FinancialStatement> financialStatements, Set<CreditHistory> creditHistories) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.financialStatements = financialStatements;
        this.creditHistories = creditHistories;
    }

    public CorporateClient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Set<FinancialStatement> getFinancialStatements() {
        return financialStatements;
    }

    public void setFinancialStatements(Set<FinancialStatement> financialStatements) {
        this.financialStatements = financialStatements;
    }

    public Set<CreditHistory> getCreditHistories() {
        return creditHistories;
    }

    public void setCreditHistories(Set<CreditHistory> creditHistories) {
        this.creditHistories = creditHistories;
    }

    @Override
    public String toString() {
        return "CorporateClient{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", financialStatements=" + financialStatements +
                ", creditHistories=" + creditHistories +
                '}';
    }
}
