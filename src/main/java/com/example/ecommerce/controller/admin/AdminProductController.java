package com.example.ecommerce.controller.admin;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.services.admin.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

private final ProductService productService;

@PostMapping("/products")
public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
    ProductDto productDto1 = productService.addProduct(productDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
}

@GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {

    List<ProductDto> products = productService.getAllProducts();
    return  ResponseEntity.ok().body(products);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name){
    List<ProductDto> productDtos = productService.getAllProductsByName(name);
    return  ResponseEntity.ok().body(productDtos);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
    boolean deleted = productService.deleteProduct(productId);
    if (deleted){
        return  ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
    }



}
