package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WindowCreateAndUpdateDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String type;
}
