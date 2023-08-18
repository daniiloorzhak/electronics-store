package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WindowResponseDTO {
    private String id;
    private String name;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
