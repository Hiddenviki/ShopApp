package com.example.ProductService.services;

import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    //тут по названию находятся продукты
    public List<Product> listProducts(String title) {
        if (title != null) {
            return productRepository.findByTitle(title);
        } else {
            return productRepository.findAll();
        }
    }
//    //здесь просто список всех продуктов
//    public List<Product2> listAllProducts() {
//        return productRepository.findAll();
//    }

}
