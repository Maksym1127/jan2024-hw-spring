package com.okten.jan2024_hw.service;


import com.okten.jan2024_hw.dto.CarDto;
import com.okten.jan2024_hw.dto.MaintenanceDto;
import com.okten.jan2024_hw.dto.UpsertCarDto;
import com.okten.jan2024_hw.entity.Car;
import com.okten.jan2024_hw.entity.Maintenance;
import com.okten.jan2024_hw.mapper.CarMapper;
import com.okten.jan2024_hw.mapper.MaintenanceMapper;
import com.okten.jan2024_hw.repositories.CarServiceRepository;
import com.okten.jan2024_hw.repositories.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final MaintenanceMapper maintenanceMapper;
    private final CarServiceRepository carServiceRepository;
    private final CarMapper carMapper;

    public List<MaintenanceDto> getMaintenance(Long carId) {
        return maintenanceRepository
                .findAllByCarId(carId)
                .stream()
                .map(maintenanceMapper::mapToDto)
                .toList();
    }

    public Optional<MaintenanceDto> getMaintenanceById(Long maintenanceId) {
        return maintenanceRepository.
                findByMaintenanceId(maintenanceId)
                .map(maintenanceMapper::mapToDto);
    }

    public MaintenanceDto createMaintenance(Long carId, MaintenanceDto maintenanceDto) {
        Maintenance maintenance = maintenanceMapper.mapToEntity(maintenanceDto, carId);
        Maintenance createdMaintenance = maintenanceRepository.insert(maintenance);
        return maintenanceMapper.mapToDto(createdMaintenance);

    }

    @Transactional
    public Optional<MaintenanceDto> updateMaintenance(Long maintenanceId, MaintenanceDto maintenanceDto) {
        return maintenanceRepository
                .findByMaintenanceId(maintenanceId)
                .map(maintenance -> {
                    return updateMaintenance(maintenance, maintenanceDto);
                })
                .map(maintenanceMapper::mapToDto);
    }

    private Maintenance updateMaintenance(Maintenance maintenance, MaintenanceDto maintenanceDto) {
        maintenance.setName(maintenanceDto.getName());
        maintenance.setDescription(maintenanceDto.getDescription());
        maintenance.setPrice(maintenanceDto.getPrice());
        return maintenance;
    }

    @Transactional
    public List<MaintenanceDto> deleteMaintenance(Long maintenanceId) {
        return maintenanceRepository
                .findByMaintenanceId(maintenanceId)
                .stream()
                .peek(maintenanceRepository::delete)
                .map(maintenanceMapper::mapToDto).toList();
    }
    private Maintenance deleteMaintenance(Maintenance maintenance) {
        return maintenanceRepository.findByMaintenanceId(maintenance.getMaintenanceId())
                .orElseThrow(() -> new EntityNotFoundException("Maintenance not found with id: " + maintenance.getId()));
    }
}
