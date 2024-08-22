package com.corporateclient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateClientRequest {
    private String companyName;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private List<FinancialStatementDTO> financialStatements;
    private List<CreditHistoryDTO> creditHistories;
}
