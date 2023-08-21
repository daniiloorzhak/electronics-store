package ru.oorzhak.electronicsstore.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oorzhak.electronicsstore.dto.WindowCreateAndUpdateDTO;
import ru.oorzhak.electronicsstore.exception.WindowWithIdNotExists;
import ru.oorzhak.electronicsstore.model.Window;
import ru.oorzhak.electronicsstore.repository.WindowRepository;
import ru.oorzhak.electronicsstore.service.WindowService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WindowServiceImpl implements WindowService {
    private final WindowRepository windowRepository;

    @Override
    public List<Window> findAllWithParameters(String type,
                                              String address,
                                              LocalDateTime createdAtFrom,
                                              LocalDateTime createdAtTo,
                                              LocalDateTime updatedAtFrom,
                                              LocalDateTime updatedAtTo) {
        return windowRepository.findAllWithParameters(
                type,
                address,
                createdAtFrom,
                createdAtTo,
                updatedAtFrom,
                updatedAtTo);
    }

    @Override
    public String save(WindowCreateAndUpdateDTO windowCreateAndUpdateDTO) {
        return windowRepository.save(windowDTOToWindow(windowCreateAndUpdateDTO)).getId().toString();
    }

    @Override
    public String update(UUID id, WindowCreateAndUpdateDTO windowCreateAndUpdateDTO) {
        Window window = windowRepository
                .findById(id)
                .orElseThrow(() -> new WindowWithIdNotExists(id.toString()));
        if (windowCreateAndUpdateDTO.getName() != null)
            window.setName(windowCreateAndUpdateDTO.getName());
        if (windowCreateAndUpdateDTO.getAddress() != null)
            window.setAddress(windowCreateAndUpdateDTO.getAddress());
        if (windowCreateAndUpdateDTO.getType() != null)
            window.setType(windowCreateAndUpdateDTO.getType());
        return windowRepository.save(window).getId().toString();
    }

    @Override
    public String delete(UUID id) {
        if (!windowRepository.existsById(id))
            throw new WindowWithIdNotExists(id.toString());
        windowRepository.deleteById(id);
        return id.toString();
    }

    private Window windowDTOToWindow(WindowCreateAndUpdateDTO windowCreateAndUpdateDTO) {
        return Window.builder()
                .name(windowCreateAndUpdateDTO.getName())
                .address(windowCreateAndUpdateDTO.getAddress())
                .type(windowCreateAndUpdateDTO.getType())
                .build();
    }
}
