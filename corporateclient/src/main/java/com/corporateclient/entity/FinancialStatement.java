package com.corporateclient.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FinancialStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "corporate_client_id")
    private CorporateClient corporateClient;

    private String year;
    private Double revenue;
    private Double profit;

    public FinancialStatement(Long id, CorporateClient corporateClient, String year, Double revenue, Double profit) {
        this.id = id;
        this.corporateClient = corporateClient;
        this.year = year;
        this.revenue = revenue;
        this.profit = profit;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "FinancialStatement{" +
                "id=" + id +
                ", corporateClient=" + corporateClient +
                ", year='" + year + '\'' +
                ", revenue=" + revenue +
                ", profit=" + profit +
                '}';
    }
}