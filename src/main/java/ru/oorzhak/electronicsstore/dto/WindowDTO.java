package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WindowDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String type;
}
