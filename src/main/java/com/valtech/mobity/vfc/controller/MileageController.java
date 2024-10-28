package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.MileageDetails;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import com.valtech.mobity.vfc.service.MileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(originPatterns = "*")
public class MileageController {

    @Autowired
    private MileageService mileageService;

    @PostMapping("/mileage")
    public ResponseEntity<NotificationResponseDto> setMileage(@RequestBody MileageDetails mileageDetails) {
        NotificationResponseDto notificationResponseDto = mileageService.setMileage(mileageDetails);
        return ResponseEntity.ok(notificationResponseDto);
    }
}
