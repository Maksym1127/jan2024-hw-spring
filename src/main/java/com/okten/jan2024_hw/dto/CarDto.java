package com.okten.jan2024_hw.dto;


import com.okten.jan2024_hw.entity.CarAvailability;
import com.okten.jan2024_hw.entity.FuelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private Long id;
    private String model;
    private Double enginePower;
    private FuelType fuelType;
    private CarAvailability availability;

}
