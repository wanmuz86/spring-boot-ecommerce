package com.example.ecommerce.controller.admin;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

    private  final CategoryService categoryService;


    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }
}
