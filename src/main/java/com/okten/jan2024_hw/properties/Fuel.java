package com.okten.jan2024_hw.properties;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Fuel {
    private String name;
    private List<String> types;

}
