package com.troyka.market.persistence.crud;

import com.troyka.market.persistence.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCrudRepository extends CrudRepository<Producto,Integer> {
}
