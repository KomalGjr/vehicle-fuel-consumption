package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.EfficiencyTargetRequestDto;
import com.valtech.mobity.vfc.dto.EfficiencyTargetResponseDto;
import com.valtech.mobity.vfc.dto.MileageDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MileageController {

    @PostMapping("/efficiencyTarget")
    public EfficiencyTargetResponseDto setEfficiencyTarget(@RequestBody EfficiencyTargetRequestDto dto) {
        // save target in db
        return new EfficiencyTargetResponseDto();

    }

    @PostMapping("/mileage")
    public ResponseEntity<Object> setMileage(@RequestBody MileageDetails milageDetails) {
        // update mileage in db

        // update notification table if needed

        return ResponseEntity.accepted().build();
    }
}
