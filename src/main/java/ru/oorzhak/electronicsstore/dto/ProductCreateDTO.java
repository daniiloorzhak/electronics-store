package ru.oorzhak.electronicsstore.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ProductCreateDTO {
    @NotNull
    private UUID windowId;
    @NotNull
    private Long position;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotNull
    @Min(1)
    private Long price;
}
