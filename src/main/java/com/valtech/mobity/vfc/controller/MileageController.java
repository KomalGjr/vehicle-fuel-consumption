package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.MileageDetailsRequestDto;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import com.valtech.mobity.vfc.model.MileageDetails;
import com.valtech.mobity.vfc.service.MileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mileage")
@CrossOrigin(originPatterns = "*")
public class MileageController {

    @Autowired
    private MileageService mileageService;

    @PostMapping
    public ResponseEntity<NotificationResponseDto> setMileage(@RequestBody MileageDetailsRequestDto mileageDetails) {
        NotificationResponseDto notificationResponseDto = mileageService.setMileage(mileageDetails);
        return ResponseEntity.ok(notificationResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<MileageDetails>> getMileage(@RequestParam long vehicleId, @RequestParam long userId) {
        List<MileageDetails> mileages = mileageService.getMileageByVehicleIdAndUserId(vehicleId, userId);
        return ResponseEntity.ok(mileages);
    }

    @GetMapping("/averageMileage")
    public ResponseEntity<Double> getAverageMileage(@RequestParam long vehicleId, @RequestParam long userId) {
        Double averageMileage = mileageService.getAverageMileage(userId, vehicleId);
        return ResponseEntity.ok(averageMileage);
    }
}
