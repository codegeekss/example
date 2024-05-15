package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Long id;
    private String product;
    private double amount;

    // Constructors, getters, and setters

    // Omitted for brevity
}
