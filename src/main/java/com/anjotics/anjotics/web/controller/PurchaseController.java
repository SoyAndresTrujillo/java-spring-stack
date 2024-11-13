package com.anjotics.anjotics.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjotics.anjotics.domain.PurchaseDomain;
import com.anjotics.anjotics.domain.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDomain>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseDomain>> getByCustomer(@PathVariable("customerId") String customerId) {
        return purchaseService.getByCustomer(customerId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/save")
    public ResponseEntity<PurchaseDomain> save(@RequestBody PurchaseDomain purchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.save(purchase));
    }
}
