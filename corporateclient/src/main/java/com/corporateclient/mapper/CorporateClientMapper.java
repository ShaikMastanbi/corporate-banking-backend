package com.corporateclient.mapper;

import com.corporateclient.dto.AddCorporateClientRequest;
import com.corporateclient.entity.CorporateClient;
import com.corporateclient.entity.CreditHistory;
import com.corporateclient.entity.FinancialStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CorporateClientMapper {

    public CorporateClient toEntity(AddCorporateClientRequest request) {
        CorporateClient corporateClient = new CorporateClient();
        corporateClient.setCompanyName(request.getCompanyName());
        corporateClient.setAddress(request.getAddress());
        corporateClient.setContactEmail(request.getContactEmail());
        corporateClient.setContactPhone(request.getContactPhone());

        Set<FinancialStatement> financialStatements = request.getFinancialStatements().stream()
                .map(dto -> {
                    FinancialStatement statement = new FinancialStatement();
                    statement.setYear(dto.getYear());
                    statement.setRevenue(dto.getRevenue());
                    statement.setProfit(dto.getProfit());
                    statement.setCorporateClient(corporateClient);
                    return statement;
                })
                .collect(Collectors.toSet());

        Set<CreditHistory> creditHistories = request.getCreditHistories().stream()
                .map(dto -> {
                    CreditHistory history = new CreditHistory();
                    history.setCreditScore(dto.getCreditScore());
                    history.setCreditStatus(dto.getCreditStatus());
                    history.setCorporateClient(corporateClient);
                    return history;
                })
                .collect(Collectors.toSet());

        corporateClient.setFinancialStatements(financialStatements);
        corporateClient.setCreditHistories(creditHistories);

        return corporateClient;
    }

}
