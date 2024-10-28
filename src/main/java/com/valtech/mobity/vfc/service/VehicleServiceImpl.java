package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.VehicleDetailsRequestDto;
import com.valtech.mobity.vfc.model.VehicleDetails;
import com.valtech.mobity.vfc.repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;

    @Override
    public VehicleDetails saveVehicle(VehicleDetailsRequestDto vehicleDetailsRequestDto) {
        VehicleDetails vehicleDetails = VehicleDetails.builder()
                .model(vehicleDetailsRequestDto.getModel())
                .manufacturer(vehicleDetailsRequestDto.getManufacturer())
                .build();

        return vehicleDetailsRepository.save(vehicleDetails);
    }

    @Override
    public Optional<VehicleDetails> getVehicleById(Long vehicleId) {
        return vehicleDetailsRepository.findById(vehicleId);
    }

    @Override
    public List<VehicleDetails> getAllVehicles() {
        return vehicleDetailsRepository.findAll();
    }

}
