package com.example.ecommerce.services.admin.product;

import com.example.ecommerce.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto) throws IOException;

    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductsByName(String name);

     boolean deleteProduct(Long productId);
}
