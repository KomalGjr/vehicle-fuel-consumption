package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CarRestController {


    @GetMapping("/notification")
    public NotificationResponseDto getNotifications(@RequestParam(name = "vehicleId") String vehicleId,
                                                    @RequestParam(name = "userId") String userId) {
        // get notification for user and car
        return new NotificationResponseDto();

    }

}
