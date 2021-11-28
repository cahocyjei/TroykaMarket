package com.troyka.market.persistence;


import com.troyka.market.domain.Category;
import com.troyka.market.domain.repository.CategoryRepository;
import com.troyka.market.persistence.crud.CategoriaCrudRepository;
import com.troyka.market.persistence.entitys.Categoria;
import com.troyka.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> getAll() {
        return categoryMapper.toCategories(categoriaCrudRepository.findAll());
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoriaCrudRepository.save(categoria));
    }
}
