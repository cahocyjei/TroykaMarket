package com.troyka.market.persistence;

import com.troyka.market.persistence.crud.ProdutoCrudRepository;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProdutoCrudRepository produtoCrudRepository;

    public List<Producto> getAll(){

        return (List<Producto>) produtoCrudRepository.findAll();
    }

    public List<Producto> getCategoria(int idCategoria){
        return produtoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return produtoCrudRepository.findByCantidad_stockLessThanAndEstado(cantidad,true);
    }


}
