package com.okten.jan2024_hw.controller;


import com.okten.jan2024_hw.properties.Fuel;
import com.okten.jan2024_hw.properties.ReferenceDataProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/reference-data")
@RequiredArgsConstructor
public class ReferenceDataController {
    //
//    @Value("${reference-data.engineTypes}")
//
//    private List<String> engines;
//    private final ReferenceDataProperties referenceDataProperties;
//
//    @GetMapping("/engine-types")
//    public ResponseEntity<List<String>> getEngineTypes() {
//        return ResponseEntity.ok(engines);
//    }
    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes() {
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }
//
//    @GetMapping("/fuel-types/{name}")
//    public ResponseEntity<Fuel> getFuelName(@PathVariable String name) {
//        return ResponseEntity
//                .of(referenceDataProperties
//                        .getFuels()
//                        .stream()
//                        .filter(fuel -> Objects.equals(fuel.getName(),name))
//                        .findFirst()
//                );
//
//    }
    private final ReferenceDataProperties referenceDataProperties;
}


