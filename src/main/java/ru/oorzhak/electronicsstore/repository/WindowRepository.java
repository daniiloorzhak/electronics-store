package ru.oorzhak.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.electronicsstore.model.Window;

public interface WindowRepository extends JpaRepository<Window, String> {
}
