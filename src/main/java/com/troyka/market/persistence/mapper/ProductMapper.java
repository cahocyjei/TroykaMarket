package com.troyka.market.persistence.mapper;

import com.troyka.market.domain.dto.Product;
import com.troyka.market.persistence.entitys.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source= "idProducto",target="productId"),
            @Mapping(source= "nombre",target = "name"),
            @Mapping(source = "image",target = "image"),
            @Mapping(source= "idCategoria",target="categoryId"),
            @Mapping(source= "precioVenta",target = "price"),
            @Mapping(source= "cantidadStock",target="stock"),
            @Mapping(source= "estado",target = "active"),
            @Mapping(source= "categoria",target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target="codigoBarras",ignore = true)
    Producto toProducto(Product product);

}
