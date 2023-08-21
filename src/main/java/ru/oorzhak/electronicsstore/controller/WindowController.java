package ru.oorzhak.electronicsstore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oorzhak.electronicsstore.dto.WindowCreateAndUpdateDTO;
import ru.oorzhak.electronicsstore.service.WindowService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@Tag(name = "Windows")
@RestController
@RequestMapping("api/v1/windows")
@AllArgsConstructor
public class WindowController {
    private final WindowService windowService;

    @GetMapping
    public ResponseEntity<?> getWindows(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String address,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime createdAtFrom,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime createdAtTo,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime updatedAtFrom,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime updatedAtTo) {
        return ResponseEntity.ok(windowService.findAllWithParameters(
                type,
                address,
                createdAtFrom,
                createdAtTo,
                updatedAtFrom,
                updatedAtTo));
    }

    @PostMapping
    public ResponseEntity<String> createWindow(@Valid  @RequestBody WindowCreateAndUpdateDTO windowCreateAndUpdateDTO) {
        return ResponseEntity.ok(windowService.save(windowCreateAndUpdateDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateWindow(@PathVariable UUID id,@Valid @RequestBody WindowCreateAndUpdateDTO windowCreateAndUpdateDTO) {
        return ResponseEntity.ok(windowService.update(id, windowCreateAndUpdateDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWindow(@PathVariable UUID id) {
        return ResponseEntity.ok(windowService.delete(id));
    }
}
