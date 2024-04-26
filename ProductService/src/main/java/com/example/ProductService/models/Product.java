package com.example.ProductService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id; //айди рподукта в бд
    @Column(name = "type")
    private Enum<Type> type; //тип продукта
    @Column(name = "title")
    private String title; //название продукта
    @Column(name = "description")
    private String description; //описание
    @Column(name = "price")
    private BigDecimal price; //цена
    @Column(name = "amount")
    private int amount; //количество в наличии
    //один товар со многими фотографиями
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product") //лейзи потому что тут уже первостепенно у нас подгрузка товара а не всех его фотографий
//    private List<Image> images = new ArrayList<>();
//    private Long previewImageId; //чтобы не обращаться к images

//    public void addImageToProduct(Image image) {
//        image.setProduct(this);
//        images.add(image);
//    }

}




