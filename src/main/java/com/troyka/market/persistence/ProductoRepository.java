package com.troyka.market.persistence;

import com.troyka.market.domain.Product;
import com.troyka.market.domain.repository.ProductRepository;
import com.troyka.market.persistence.crud.ProdutoCrudRepository;
import com.troyka.market.persistence.entitys.Producto;
import com.troyka.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProdutoCrudRepository produtoCrudRepository;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) produtoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = produtoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos= produtoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return produtoCrudRepository.findById(productId).map(prod ->productMapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto= productMapper.toProducto(product);
        return productMapper.toProduct(produtoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        produtoCrudRepository.deleteById(productId);
    }

}
