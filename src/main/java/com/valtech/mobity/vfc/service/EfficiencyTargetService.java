package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.EfficiencyTargetRequestDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;

import java.util.List;
import java.util.Optional;

public interface EfficiencyTargetService {
    public EfficiencyTarget saveEfficiencyTarget(EfficiencyTargetRequestDto requestDto);
    public Optional<EfficiencyTarget> getEfficiencyTargetById(Long id);
    public EfficiencyTarget getEfficiencyTargetsByUserIdAndVehicleId(long userId, long vehicleId);
    public void deleteEfficiencyTarget(Long id);

}
