package com.okten.jan2024_hw.repositories;

import com.okten.jan2024_hw.entity.Maintenance;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MaintenanceRepository extends MongoRepository<Maintenance, ObjectId> {

    List<Maintenance> findAllByCarId(Long carId);

    Optional<Maintenance> findByMaintenanceId(Long maintenanceId);


}
