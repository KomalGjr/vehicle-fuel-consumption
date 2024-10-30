package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.EfficiencyTargetRequestDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;

import java.util.Optional;

public interface EfficiencyTargetService {
    EfficiencyTarget saveEfficiencyTarget(EfficiencyTargetRequestDto requestDto);

    EfficiencyTarget updateEfficiencyTarget(EfficiencyTargetRequestDto requestDto);

    Optional<EfficiencyTarget> getEfficiencyTargetById(Long id);

    EfficiencyTarget getEfficiencyTargetsByUserIdAndVehicleId(long userId, long vehicleId);

    void deleteEfficiencyTarget(Long id);

}
