package com.valtech.mobity.vfc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VehicleDetailsRequestDto {

    private String model;
    private String manufacturer;
}
