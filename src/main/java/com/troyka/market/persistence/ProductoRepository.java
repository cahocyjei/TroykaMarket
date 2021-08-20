package com.troyka.market.persistence;

import com.troyka.market.persistence.crud.ProdutoCrudRepository;

import java.util.List;

public class ProductoRepository {

    private ProdutoCrudRepository produtoCrudRepository;

    public List<Producto> getAll(){

        return (List<Producto>) produtoCrudRepository.findAll();
    }
}
