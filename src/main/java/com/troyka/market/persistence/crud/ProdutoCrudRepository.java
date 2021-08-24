package com.troyka.market.persistence.crud;

import com.troyka.market.persistence.entitys.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProdutoCrudRepository extends CrudRepository<Producto,Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

  Optional<List<Producto>> findByCantidad_stockLessThanAndEstado(int cantidad_stock,boolean estado);
}
