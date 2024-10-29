package com.okten.jan2024_hw.validation;

import com.okten.jan2024_hw.entity.FuelType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Value;

import java.util.List;

public class FuelTypeValidator implements ConstraintValidator<ValidFuelType, String> {

    @Override
    public boolean isValid(String fuelType, ConstraintValidatorContext context) {
        if (fuelType == null) {
            return true;  // Дозволяємо значення null, але можна додати @NotNull для обов'язковості
        }
        try {
            FuelType.valueOf(fuelType);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


}
