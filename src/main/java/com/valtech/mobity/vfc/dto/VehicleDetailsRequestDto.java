package com.valtech.mobity.vfc.dto;

import lombok.Data;

@Data
public class VehicleDetailsRequestDto {

    private String model;

    private int year;

    private String vin; // Vehicle Identification Number

    private String color;

    private double mileage;

    private String fuelType;//Gasoline,Diesel,Electric,Hybrid,Ethanol,LPG,CNG
}
