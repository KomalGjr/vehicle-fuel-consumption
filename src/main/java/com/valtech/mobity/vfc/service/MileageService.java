package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.MileageDetailsRequestDto;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import com.valtech.mobity.vfc.model.MileageDetails;

import java.util.List;

public interface MileageService {
    NotificationResponseDto setMileage(MileageDetailsRequestDto mileageDetails);
    List<MileageDetails> getMileageByVehicleIdAndUserId(long vehicleId, long userId);
    Double getAverageMileage(Long userId, Long vehicleId);
}
