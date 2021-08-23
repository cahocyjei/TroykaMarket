package com.troyka.market.persistence;

import com.troyka.market.persistence.crud.ProdutoCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Producto> geProducto(int id_Producto){
        return produtoCrudRepository.findById(id_Producto);
    }
    public Producto save(Producto producto){
        return produtoCrudRepository.save(producto);
    }
    public void delete(int id_Producto){
        produtoCrudRepository.deleteById(id_Producto);
    }


}
