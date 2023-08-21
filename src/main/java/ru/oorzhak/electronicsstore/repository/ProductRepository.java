package ru.oorzhak.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.oorzhak.electronicsstore.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p from Product p " +
            "WHERE (cast(p.window.id as string) = cast(:windowId as string)) " +
            "   and (:type is null or p.type = :type) " +
            "   and (:priceFrom is null or p.price >= :priceFrom) " +
            "   and (:priceTo is null or p.price <= :priceTo)")
    List<Product> findAllWithParameters(
            String windowId,
            String type,
            Long priceFrom,
            Long priceTo);
}
