package ru.oorzhak.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.oorzhak.electronicsstore.model.Window;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WindowRepository extends JpaRepository<Window, UUID> {
    @Query(value = "SELECT w from Window w " +
            "WHERE (:type is null or w.type = :type)" +
            "   and (:address is null or w.address = :address)" +
            "   and ((cast(:createdAtFrom as timestamp ) is null) or w.createdAt >= :createdAtFrom) " +
            "   and ((cast(:createdAtTo as timestamp) is null) or w.createdAt <= :createdAtTo)" +
            "   and ((cast(:updatedAtFrom as timestamp) is null) or w.updatedAt >= :updatedAtFrom) " +
            "   and ((cast(:updatedAtTo as timestamp) is null) or w.updatedAt <= :updatedAtTo)")
    List<Window> findAllWithParameters(
            String type,
            String address,
            LocalDateTime createdAtFrom,
            LocalDateTime createdAtTo,
            LocalDateTime updatedAtFrom,
            LocalDateTime updatedAtTo);
}
