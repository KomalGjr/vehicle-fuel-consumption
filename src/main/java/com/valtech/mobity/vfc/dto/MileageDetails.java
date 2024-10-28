package com.valtech.mobity.vfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MileageDetails {

    private String vehicleId;

    private String userId;

    private Float currentMileage;

}
