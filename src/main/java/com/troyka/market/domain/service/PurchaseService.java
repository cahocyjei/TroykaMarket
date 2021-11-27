package com.troyka.market.domain.service;

import com.troyka.market.Application;
import com.troyka.market.domain.Purchase;
import com.troyka.market.domain.repository.PurchaseRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {


    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return  purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByIdClient(String clientId) {
        return purchaseRepository.getByIdClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
