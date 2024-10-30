package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.VehicleDetailsRequestDto;
import com.valtech.mobity.vfc.model.VehicleDetails;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    VehicleDetails saveVehicle(VehicleDetailsRequestDto vehicleDetailsRequestDto);

    Optional<VehicleDetails> getVehicleById(Long vehicleId);

    List<VehicleDetails> getAllVehicles();

}
