package ru.oorzhak.electronicsstore.service;

import ru.oorzhak.electronicsstore.dto.ProductCreateDTO;
import ru.oorzhak.electronicsstore.dto.ProductUpdateDTO;
import ru.oorzhak.electronicsstore.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAllWithParameters(
            UUID windowId,
            String type,
            Long priceFrom,
            Long priceTo);
    Long save(ProductCreateDTO productDTO);
    Long update(Long id, ProductUpdateDTO productDTO);
    Long delete(Long id);
}
