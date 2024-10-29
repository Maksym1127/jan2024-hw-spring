package com.okten.jan2024_hw.entity;


import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Document("carMaintenance")
public class Maintenance {

    @MongoId
    private ObjectId id;

    private Long maintenanceId;

    private String name;

    private String description;

    private Double price;

    private LocalDateTime lastMaintenanceTimestamp;

}
