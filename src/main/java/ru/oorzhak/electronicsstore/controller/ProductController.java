package ru.oorzhak.electronicsstore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oorzhak.electronicsstore.dto.ProductCreateDTO;
import ru.oorzhak.electronicsstore.dto.ProductUpdateDTO;
import ru.oorzhak.electronicsstore.service.ProductService;

import java.util.Date;

@Tag(name = "Product", description = "Description")
@RestController("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(
            @PathVariable Long windowId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Date priceFrom,
            @RequestParam(required = false) Date priceTo) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@PathVariable ProductCreateDTO productDTO) {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductUpdateDTO productDTO) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return null;
    }
}
