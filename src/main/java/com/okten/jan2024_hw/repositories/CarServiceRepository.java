package com.okten.jan2024_hw.repositories;

import com.okten.jan2024_hw.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarServiceRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByEnginePowerBetween(Double minEnginePower, Double maxEnginePower);
    List<Car> findAllByEnginePowerGreaterThan(Double minEnginePower);
    List<Car> findAllByEnginePowerLessThan(Double maxEnginePower);

}
