package com.okten.jan2024_hw.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MaintenanceDto {

    @NotBlank
    private String name;

    private String description;

    @Min(1)
    private Double price;

    private LocalDateTime lastMaintenanceTimestamp;
}
