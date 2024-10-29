package com.okten.jan2024_hw.mapper;

import com.okten.jan2024_hw.dto.MaintenanceDto;
import com.okten.jan2024_hw.entity.Maintenance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(imports = LocalDateTime.class)
public interface MaintenanceMapper {

    MaintenanceDto mapToDto(Maintenance maintenance);

    @Mapping(target = "lastMaintenanceTimestamp", expression = "java(LocalDateTime.now())")
    Maintenance mapToEntity(MaintenanceDto dto, Long carId);

}
