package com.example.ProductService.controllers;

import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        // Реализация метода получения списка всех товаров
        return productService.listProducts(null);
    }



}








//    @GetMapping("/{id}")
//    public Product2 getProductById(@PathVariable Long id) {
//        // Реализация метода получения информации о товаре по его идентификатору
//        return null;
//    }
//
//    @PostMapping("/create")
//    public String createProduct(@RequestBody Product2 product) {
//        // Реализация метода создания нового товара
//        return null;
//    }
//
//    @PutMapping("/{id}/update")
//    public String updateProduct(@PathVariable Long id, @RequestBody Product2 product) {
//        // Реализация метода обновления информации о товаре
//        return null;
//    }
//
//    @DeleteMapping("/{id}/delete")
//    public String deleteProduct(@PathVariable Long id) {
//        // Реализация метода удаления товара
//        return null;
//    }
//}
