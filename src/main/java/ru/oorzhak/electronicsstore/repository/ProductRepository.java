package ru.oorzhak.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.electronicsstore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
