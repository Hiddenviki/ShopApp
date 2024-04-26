package com.example.ProductService.controllers;

import com.example.ProductService.models.Image;
import com.example.ProductService.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        // Получаем изображение из репозитория по указанному ID
        Image image = imageRepository.findById(id).orElse(null);

        // Проверяем, было ли найдено изображение по указанному ID
        if (image == null) {
            // Возвращаем HTTP статус "404 Not Found", если изображение не найдено
            return ResponseEntity.notFound().build();
        }

        try {
            // Возвращаем данные изображения в ответе ResponseEntity
            return ResponseEntity.ok()
                    .header("fileName", image.getOriginalFileName()) // Устанавливаем заголовок с именем файла
                    .contentType(MediaType.valueOf(image.getContentType())) // Устанавливаем тип контента для изображения
                    .contentLength(image.getSize()) // Устанавливаем длину контента
                    .body(image.getBytes()); // Устанавливаем массив байтов изображения в теле ответа
        } catch (Exception e) {
            // Обрабатываем возможные исключения ууххх
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}