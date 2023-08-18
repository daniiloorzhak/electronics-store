package ru.oorzhak.electronicsstore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oorzhak.electronicsstore.dto.WindowDTO;
import ru.oorzhak.electronicsstore.service.WindowService;

import java.util.Date;

@Tag(name = "Window", description = "Description")
@RestController("/api/v1/windows")
@AllArgsConstructor
public class WindowController {
    private final WindowService windowService;

    @GetMapping
    public ResponseEntity<?> getAllWindows(
            @RequestParam String type,
            @RequestParam String address,
            @RequestParam Date createdFrom,
            @RequestParam Date createdTo,
            @RequestParam Date updatedFrom,
            @RequestParam Date updatedTo) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createWindow(@RequestBody WindowDTO windowDTO) {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateWindow(@PathVariable Long id, @RequestBody WindowDTO windowDTO) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteWindow(@PathVariable Long id) {
        return null;
    }
}

