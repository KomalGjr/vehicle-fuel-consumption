package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(originPatterns = "*")
public class CarRestController {


    @GetMapping("/notification")
    public NotificationResponseDto getNotifications(@RequestParam(name = "vehicleId") String vehicleId,
                                                    @RequestParam(name = "userId") String userId) {
        // get notification for user and car
        return new NotificationResponseDto("Efficiency is within in range at " + new Date());

    }

}
