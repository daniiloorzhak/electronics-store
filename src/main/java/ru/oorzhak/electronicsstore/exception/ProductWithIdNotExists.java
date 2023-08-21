package ru.oorzhak.electronicsstore.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductWithIdNotExists extends RuntimeException {
    private final Long id;

    @Override
    public String getMessage() {
        return String.format("Product with ID '%d' does not exist", id);
    }
}
