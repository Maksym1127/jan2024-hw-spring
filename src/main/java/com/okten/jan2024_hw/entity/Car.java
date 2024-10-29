package com.okten.jan2024_hw.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Double enginePower;
    @Enumerated(EnumType.ORDINAL)
    private CarAvailability availability;
    private FuelType fuelType;
//
//    @Enumerated(EnumType.STRING)
//    private ProductAvailability availability;
}
