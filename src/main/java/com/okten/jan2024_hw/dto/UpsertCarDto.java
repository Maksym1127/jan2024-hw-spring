package com.okten.jan2024_hw.dto;


import com.okten.jan2024_hw.entity.CarAvailability;
import com.okten.jan2024_hw.entity.FuelType;
//import com.okten.jan2024_hw.validation.ValidFuelType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpsertCarDto {

    @NotBlank
    public String model;

    @DecimalMin("0")
    private Double enginePower;

    private CarAvailability availability;

//    @ValidFuelType
    private FuelType fuelType;

}
