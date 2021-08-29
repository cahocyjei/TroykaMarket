package com.troyka.market.domain.repository;

import com.troyka.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByIdClient(String clientId);
    Purchase save(Purchase purchase);

}
