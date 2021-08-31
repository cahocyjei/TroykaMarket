package com.troyka.market.domain.service;

import com.troyka.market.domain.Category;
import com.troyka.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
}
