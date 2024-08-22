package com.corporateclient.service;

import com.corporateclient.entity.FinancialStatement;
import com.corporateclient.repository.FinancialStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialStatementService {
    @Autowired
    private FinancialStatementRepository financialStatementRepository;

    public FinancialStatement createStatement(FinancialStatement statement) {
        return financialStatementRepository.save(statement);
    }

    public FinancialStatement getStatementById(Long id) {
        return financialStatementRepository.findById(id).orElse(null);
    }

    public FinancialStatement updateStatement(Long id, FinancialStatement statement) {
        if (financialStatementRepository.existsById(id)) {
            statement.setId(id);
            return financialStatementRepository.save(statement);
        }
        return null;
    }

    public void deleteStatement(Long id) {
        financialStatementRepository.deleteById(id);
    }
}