package ru.oorzhak.electronicsstore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oorzhak.electronicsstore.dto.ProductCreateDTO;
import ru.oorzhak.electronicsstore.dto.ProductUpdateDTO;
import ru.oorzhak.electronicsstore.model.Product;
import ru.oorzhak.electronicsstore.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Products")
@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam UUID windowId,
                                                     @RequestParam(required = false) String type,
                                                     @RequestParam(required = false) Long priceFrom,
                                                     @RequestParam(required = false) Long priceTo) {
        return ResponseEntity.ok(productService.findAllWithParameters(windowId, type, priceFrom, priceTo));
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@Valid @RequestBody ProductCreateDTO productDTO) {
        return ResponseEntity.ok(productService.save(productDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<Long> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateDTO productDTO) {
        return ResponseEntity.ok(productService.update(id, productDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }
}
