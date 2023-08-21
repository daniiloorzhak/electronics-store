package ru.oorzhak.electronicsstore.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WindowWithIdNotExists extends RuntimeException {
    private final String id;

    @Override
    public String getMessage() {
        return String.format("Window with ID '%s' does not exist", id);
    }
}
