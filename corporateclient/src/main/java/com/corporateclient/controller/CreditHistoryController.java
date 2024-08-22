package com.corporateclient.controller;

import com.corporateclient.entity.CreditHistory;
import com.corporateclient.service.CreditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/credit-histories")
public class CreditHistoryController {
    @Autowired
    private CreditHistoryService creditHistoryService;

    @PostMapping
    public ResponseEntity<CreditHistory> createCreditHistory(@RequestBody CreditHistory creditHistory) {
        return ResponseEntity.ok(creditHistoryService.createCreditHistory(creditHistory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditHistory> getCreditHistoryById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(creditHistoryService.getCreditHistoryById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditHistory> updateCreditHistory(@PathVariable Long id, @RequestBody CreditHistory creditHistory) {
        CreditHistory updatedCreditHistory = creditHistoryService.updateCreditHistory(id, creditHistory);
        return updatedCreditHistory != null ? ResponseEntity.ok(updatedCreditHistory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditHistory(@PathVariable Long id) {
        creditHistoryService.deleteCreditHistory(id);
        return ResponseEntity.noContent().build();
    }
}