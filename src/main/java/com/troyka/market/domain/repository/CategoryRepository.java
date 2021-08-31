package com.troyka.market.domain.repository;

import com.troyka.market.domain.Category;

import java.util.List;


public interface CategoryRepository {

    List<Category> getAll();
    Category save(Category category);
}
