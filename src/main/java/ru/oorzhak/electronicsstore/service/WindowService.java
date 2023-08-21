package ru.oorzhak.electronicsstore.service;

import ru.oorzhak.electronicsstore.dto.WindowCreateAndUpdateDTO;
import ru.oorzhak.electronicsstore.model.Window;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WindowService {
    List<Window> findAllWithParameters(String type, String address, LocalDateTime createdAtFrom, LocalDateTime createdAtTo, LocalDateTime updatedAtFrom, LocalDateTime updatedAtTo);
    String save(WindowCreateAndUpdateDTO windowCreateAndUpdateDTO);
    String update(UUID id, WindowCreateAndUpdateDTO windowCreateAndUpdateDTO);
    String delete(UUID id);
}
