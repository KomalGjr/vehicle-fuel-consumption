package com.valtech.mobity.vfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EfficiencyTargetRequestDto {

    private Double efficientTargetValue;

    private int status;

    private long userId;

    private long vehicleId;
}
