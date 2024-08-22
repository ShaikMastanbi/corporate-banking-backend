package com.corporateclient.controller;

import com.corporateclient.entity.FinancialStatement;
import com.corporateclient.service.FinancialStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/financial-statements")
public class FinancialStatementController {
    @Autowired
    private FinancialStatementService financialStatementService;

    @PostMapping
    public ResponseEntity<FinancialStatement> createStatement(@RequestBody FinancialStatement statement) {
        return ResponseEntity.ok(financialStatementService.createStatement(statement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialStatement> getStatementById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(financialStatementService.getStatementById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialStatement> updateStatement(@PathVariable Long id, @RequestBody FinancialStatement statement) {
        FinancialStatement updatedStatement = financialStatementService.updateStatement(id, statement);
        return updatedStatement != null ? ResponseEntity.ok(updatedStatement) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatement(@PathVariable Long id) {
        financialStatementService.deleteStatement(id);
        return ResponseEntity.noContent().build();
    }
}