package com.corporateclient.repository;

import com.corporateclient.entity.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, Long> {
}
