package com.okten.jan2024_hw.mapper;

import com.okten.jan2024_hw.dto.CarDto;
import com.okten.jan2024_hw.dto.UpsertCarDto;
import com.okten.jan2024_hw.entity.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CarMapper {

    public CarDto mapToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .fuelType(car.getFuelType())
                .availability(car.getAvailability())
                .build();
    }

    public Car mapToEntity(UpsertCarDto dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setEnginePower(dto.getEnginePower());
        car.setFuelType(dto.getFuelType());
        car.setAvailability(dto.getAvailability());
        return car;
    }

}
