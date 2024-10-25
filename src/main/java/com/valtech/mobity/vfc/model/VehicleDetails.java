package com.valtech.mobity.vfc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private String model;

    private int year;

    private String vin; // Vehicle Identification Number

    private String color;

    private double mileage;

    private String fuelType;//Gasoline,Diesel,Electric,Hybrid,Ethanol,LPG,CNG
}