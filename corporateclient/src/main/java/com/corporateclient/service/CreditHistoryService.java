package com.corporateclient.service;

import com.corporateclient.entity.CorporateClient;
import com.corporateclient.entity.CreditHistory;
import com.corporateclient.repository.CorporateClientRepository;
import com.corporateclient.repository.CreditHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditHistoryService {
    @Autowired
    private CreditHistoryRepository creditHistoryRepository;
    @Autowired
    private CorporateClientRepository corporateClientRepository;

    public CreditHistory createCreditHistory(CreditHistory creditHistory) {

        return creditHistoryRepository.save(creditHistory);
    }

    public CreditHistory getCreditHistoryById(Long id) {
        return creditHistoryRepository.findById(id).orElse(null);
    }

    public CreditHistory updateCreditHistory(Long id, CreditHistory creditHistory) {
        if (creditHistoryRepository.existsById(id)) {
            creditHistory.setId(id);
            return creditHistoryRepository.save(creditHistory);
        }
        return null;
    }

    public void deleteCreditHistory(Long id) {
        creditHistoryRepository.deleteById(id);
    }
}