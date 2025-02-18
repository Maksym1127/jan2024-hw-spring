package com.okten.jan2024_hw.dto;


import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
public class ErrorDto {
    private List<String> details;

    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
}
