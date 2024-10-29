package com.okten.jan2024_hw.controller;

import com.okten.jan2024_hw.dto.CarDto;
import com.okten.jan2024_hw.dto.MaintenanceDto;
import com.okten.jan2024_hw.dto.UpsertCarDto;
import com.okten.jan2024_hw.service.CarService;

import com.okten.jan2024_hw.service.MaintenanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class CarServiceController {

    private final CarService carService;
    private final MaintenanceService maintenanceService;
//    private final CarServiceRepository serviceRepository;

    //GET /cars - повертає список усіх авто
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getCars(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ) {
        if (minEnginePower != null && maxEnginePower != null) {
            return ResponseEntity.ok(carService.findAllByEnginePowerBetween(minEnginePower, maxEnginePower));
        } else if (minEnginePower != null) {
            return ResponseEntity.ok(carService.findAllByEnginePowerGreaterThan(minEnginePower));
        } else if (maxEnginePower != null) {
            return ResponseEntity.ok(carService.findAllByEnginePowerLessThan(maxEnginePower));
        }
        return ResponseEntity.ok(carService.findAll());
    }

    //GET /cars/{id} - повертає конкретне авто по І
    @GetMapping("/cars/{carsId}")
    public ResponseEntity<CarDto> getById(@PathVariable Long carsId) {
        return ResponseEntity.of(carService.findById(carsId));
    }

    // POST /cars - створює нове авто
    @PostMapping("/cars")
    public ResponseEntity<CarDto> create(@Valid @RequestBody UpsertCarDto car) {
        return ResponseEntity.ok(carService.save(car));
    }

    //PUT /cars/{id} - оновлює дані про авто по ІД
    @PutMapping("/cars/{carsId}")
    public ResponseEntity<CarDto> update(@PathVariable Long carsId, @Valid @RequestBody UpsertCarDto carUpdateWith) {
        return ResponseEntity.of(carService.update(carsId,carUpdateWith));
    }

    //DELETE /cars/{id} - видалити авто по ІД

    @DeleteMapping("/cars/{carsId}")
    public ResponseEntity<CarDto> delete(@PathVariable Long carsId) {
        return ResponseEntity.of(carService.delete(carsId));
    }

    @GetMapping("/cars/{carId}/maintenances")
    public ResponseEntity<List<MaintenanceDto>> getMaintenances(@PathVariable Long carId) {
        return ResponseEntity.ok(maintenanceService.getMaintenance(carId));
    }

    @GetMapping("/cars/{carId}/maintenances/{maintenancesId}")
    public ResponseEntity<MaintenanceDto> getMaintenanceById( @PathVariable Long maintenancesId){
        return ResponseEntity.of(maintenanceService.getMaintenanceById(maintenancesId));
    }

    @PostMapping("/cars/{carId}/maintenances")
    public ResponseEntity<MaintenanceDto> createMaintenance(@PathVariable Long carId, @Valid @RequestBody MaintenanceDto maintenanceDto) {
        return ResponseEntity.ok(maintenanceService.createMaintenance(carId,maintenanceDto));
    }

//    @GetMapping("/fuel-types")
////    public ResponseEntity<List<Fuel>> getFuelTypes() {
////        return ResponseEntity.ok(referenceDataProperties.getFuels());
////    }
}
