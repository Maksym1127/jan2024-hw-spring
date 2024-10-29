package com.okten.jan2024_hw.validation;

import com.okten.jan2024_hw.entity.FuelType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FuelTypeValidator.class)  // Зв'язок з валідатором
@Target({ ElementType.FIELD, ElementType.PARAMETER })  // Де можна використовувати
@Retention(RetentionPolicy.RUNTIME)  // Зберігати на рівні рантайму
public @interface ValidFuelType {

    String message() default "Fuel type is not valid ";

    Class<?>[] groups() default {};  // For grouping constraints (optional)

    Class<? extends Payload>[] payload() default {};  // For additional metadata (optional)
}
