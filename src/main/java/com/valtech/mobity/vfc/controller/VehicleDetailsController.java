package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.VehicleDetailsRequestDto;
import com.valtech.mobity.vfc.model.VehicleDetails;
import com.valtech.mobity.vfc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleDetailsController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDetails> createVehicle(@RequestBody VehicleDetailsRequestDto vehicleDetailsRequestDto) {
        VehicleDetails savedVehicle = vehicleService.saveVehicle(vehicleDetailsRequestDto);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetails> getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VehicleDetails>> getAllVehicles() {
        List<VehicleDetails> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
}
