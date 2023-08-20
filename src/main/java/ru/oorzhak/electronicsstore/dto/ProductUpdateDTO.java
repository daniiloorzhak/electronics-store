package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductUpdateDTO {
    @NotNull
    private Long position;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotNull
    @Min(0)
    private Long price;
}
