package com.okten.jan2024_hw.service;


import com.okten.jan2024_hw.dto.CarDto;
import com.okten.jan2024_hw.dto.UpsertCarDto;
import com.okten.jan2024_hw.entity.Car;
import com.okten.jan2024_hw.mapper.CarMapper;
import com.okten.jan2024_hw.repositories.CarServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarServiceRepository carServiceRepository;
    private final CarMapper carMapper;

    public Optional<CarDto> findById(Long id) {
        return carServiceRepository
                .findById(id)
                .map(carMapper::mapToDto);

    }

    public List<CarDto> findAllByEnginePowerBetween(Double min, Double max) {
        return carServiceRepository
                .findAllByEnginePowerBetween(min, max)
                .stream()
                .map(carMapper::mapToDto)
                .toList();
    }

    public List<CarDto> findAllByEnginePowerGreaterThan(Double value) {
        return carServiceRepository
                .findAllByEnginePowerGreaterThan(value)
                .stream()
                .map(carMapper::mapToDto)
                .toList();
    }

    public List<CarDto> findAllByEnginePowerLessThan(Double value) {
        return carServiceRepository
                .findAllByEnginePowerLessThan(value)
                .stream()
                .map(carMapper::mapToDto)
                .toList();
    }

    public List<CarDto> findAll() {
        return carServiceRepository
                .findAll()
                .stream()
                .map(carMapper::mapToDto)
                .toList();
    }

    public CarDto save(UpsertCarDto carDto) {
        Car car = carMapper.mapToEntity(carDto);
        Car saveCar = carServiceRepository.save(car);
        return carMapper.mapToDto(saveCar);
    }

    @Transactional
    public Optional<CarDto> update(Long carId, UpsertCarDto carUpdateWith) {
        return carServiceRepository
                .findById(carId)
                .map(car -> {
                    return update(car, carUpdateWith);
                })
                .map(carMapper::mapToDto);
    }

    private Car update(Car car, UpsertCarDto dto) {
        car.setModel(dto.getModel());
        car.setEnginePower(dto.getEnginePower());
        car.setFuelType(dto.getFuelType());
        car.setAvailability(dto.getAvailability());
        return car;
    }

    @Transactional
    public Optional<CarDto> delete(Long carId) {
        return carServiceRepository
                .findById(carId)
                .map(car -> {
                    carServiceRepository.delete(car);
                    return car;
                })
                .map(carMapper::mapToDto);
    }

    private Car delete(Car car) {
        return carServiceRepository.findById(car.getId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found with id: " + car.getId()));
    }

    //    @DeleteMapping("/cars/{carsId}")
//    public ResponseEntity<CarDto> delete(@PathVariable Long carsId) {
//        if (carService.existsById(carsId)) {
//            carService.deleteById(carsId);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    private Car delete(Car car){
//        if (car.getId()!=null){
//           carServiceRepository.deleteById(car.getId());
//        }
//        return car;
//    }


}
