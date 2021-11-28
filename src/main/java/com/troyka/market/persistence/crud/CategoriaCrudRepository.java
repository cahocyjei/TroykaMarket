package com.troyka.market.persistence.crud;

import com.troyka.market.persistence.entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaCrudRepository extends JpaRepository<Categoria,Integer> {

}
