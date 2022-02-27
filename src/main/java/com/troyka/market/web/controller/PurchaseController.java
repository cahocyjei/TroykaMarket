package com.troyka.market.web.controller;

import com.troyka.market.domain.dto.Purchase;
import com.troyka.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>>  getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK) ;
    }
    @GetMapping("client/{id}")
    public ResponseEntity<List<Purchase>> getByIdClient(@PathVariable("id") String clientId) {
        return purchaseService.getByIdClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }
}
