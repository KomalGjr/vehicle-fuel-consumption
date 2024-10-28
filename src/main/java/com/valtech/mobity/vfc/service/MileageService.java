package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.MileageDetails;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;

public interface MileageService {
    NotificationResponseDto setMileage(MileageDetails mileageDetails);
}
