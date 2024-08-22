package com.corporateclient.repository;


import com.corporateclient.entity.CorporateClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateClientRepository extends JpaRepository<CorporateClient, Long> {
    CorporateClient findById(CorporateClient corporateClient);
}
