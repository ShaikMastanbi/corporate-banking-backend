package com.corporateclient.service;

import com.corporateclient.dto.AddCorporateClientRequest;
import com.corporateclient.dto.UpdateCorporateClientRequest;
import com.corporateclient.entity.CorporateClient;
import com.corporateclient.mapper.CorporateClientMapper;
import com.corporateclient.repository.CorporateClientRepository;
import com.corporateclient.repository.CreditHistoryRepository;
import com.corporateclient.service.client.UsermanagementFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorporateClientService {
    @Autowired
    private CorporateClientRepository corporateClientRepository;
    @Autowired
    private CreditHistoryRepository creditHistoryRepository;
    @Autowired
    private CorporateClientMapper corporateClientMapper;

    @Autowired
    private UsermanagementFeignClient usermanagementFeignClient;

    public CorporateClient addCorporateClient(AddCorporateClientRequest request) {
        CorporateClient corporateClient = corporateClientMapper.toEntity(request);

        return corporateClientRepository.save(corporateClient);
    }

    public Optional<CorporateClient> getClientById(Long id) {
        return corporateClientRepository.findById(id);
    }

    public CorporateClient updateClient(Long id, UpdateCorporateClientRequest request) {
        if (corporateClientRepository.existsById(id)) {
            CorporateClient client = corporateClientRepository.findById(id).orElseThrow();
            if (request.getCompanyName() != null) client.setCompanyName(request.getCompanyName());
            if (request.getAddress() != null) client.setAddress(request.getAddress());
            if (request.getContactEmail() != null) client.setContactEmail(request.getContactEmail());
            if (request.getContactPhone() != null) client.setContactPhone(request.getContactPhone());
            // Update other fields as needed

            return corporateClientRepository.save(client);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        if (corporateClientRepository.existsById(id)) {
            corporateClientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}