package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class ProductCreateDTO {
    @NotNull
    @Min(1)
    private Long windowId;
    @NotNull
    private Long position;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @Null
    @Min(0)
    private Double price;
}
