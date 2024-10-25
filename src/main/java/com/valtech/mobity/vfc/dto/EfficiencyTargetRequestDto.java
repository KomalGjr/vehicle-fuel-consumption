package com.valtech.mobity.vfc.dto;

import lombok.Data;

@Data
public class EfficiencyTargetRequestDto {

    private Double efficientTargetValue;

    private String status;

    private String userId;

    private String vehicleId;
}
