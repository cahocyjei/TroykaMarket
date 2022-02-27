package com.troyka.market.web.controller;


import com.troyka.market.domain.dto.Category;
import com.troyka.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

}
