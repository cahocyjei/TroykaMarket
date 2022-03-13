package com.troyka.market.web.controller;

import com.troyka.market.domain.dto.Product;
import com.troyka.market.domain.service.ProductService;
import com.troyka.market.web.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3005")
public class ProductController {
    private Log LOGGER = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code= 200,message = "Ok")
    public ResponseEntity<List<Product>>  getAll() {
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation("Get products by id")
    @ApiResponses({
            @ApiResponse(code= 200, message = "Ok"),
            @ApiResponse(code= 404,message = "NotFound")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id product",
            required = true,example = "7") @PathVariable("id") int productId) {
        return productService.getProduct(productId).map(prod -> new ResponseEntity<>(prod,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory(categoryId).map(prods->new ResponseEntity<>(prods,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Product>  save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
