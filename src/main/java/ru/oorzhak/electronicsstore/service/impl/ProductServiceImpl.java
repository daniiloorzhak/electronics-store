package ru.oorzhak.electronicsstore.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oorzhak.electronicsstore.dto.ProductCreateDTO;
import ru.oorzhak.electronicsstore.dto.ProductUpdateDTO;
import ru.oorzhak.electronicsstore.exception.ProductWithIdNotExists;
import ru.oorzhak.electronicsstore.exception.WindowWithIdNotExists;
import ru.oorzhak.electronicsstore.model.Product;
import ru.oorzhak.electronicsstore.model.Window;
import ru.oorzhak.electronicsstore.repository.ProductRepository;
import ru.oorzhak.electronicsstore.repository.WindowRepository;
import ru.oorzhak.electronicsstore.service.ProductService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final WindowRepository windowRepository;

    @Override
    public List<Product> findAllWithParameters(UUID windowId, String type, Long priceFrom, Long priceTo) {
        return productRepository.findAllWithParameters(windowId.toString(), type, priceFrom, priceTo);
    }

    @Override
    @Transactional
    public Long save(ProductCreateDTO productDTO) {
        Window window = windowRepository
                .findById(productDTO.getWindowId())
                .orElseThrow(() -> new WindowWithIdNotExists(productDTO.getWindowId().toString()));
        Product product = produtCreateDTOToProduct(productDTO);
        product.setWindow(window);
        return productRepository.save(product).getId();
    }

    @Override
    @Transactional
    public Long update(Long id, ProductUpdateDTO productDTO) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductWithIdNotExists(id));
        if (productDTO.getPosition() != null)
            product.setPosition(productDTO.getPosition());
        if (product.getName() != null)
            product.setName(productDTO.getName());
        if (product.getType() != null)
            product.setType(productDTO.getType());
        if (product.getPrice() != null)
            product.setPrice(productDTO.getPrice());
        return productRepository.save(product).getId();
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        if (!productRepository.existsById(id))
            throw new ProductWithIdNotExists(id);
        productRepository.deleteById(id);
        return id;
    }

    private Product produtCreateDTOToProduct(ProductCreateDTO productDTO) {
        return Product.builder()
                .position(productDTO.getPosition())
                .name(productDTO.getName())
                .type(productDTO.getType())
                .price(productDTO.getPrice())
                .build();
    }
}
