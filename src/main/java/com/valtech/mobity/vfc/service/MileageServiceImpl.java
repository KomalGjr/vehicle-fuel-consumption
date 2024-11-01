package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.MileageDetailsRequestDto;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.model.EfficiencyTargetStatus;
import com.valtech.mobity.vfc.model.MileageDetails;
import com.valtech.mobity.vfc.model.Notification;
import com.valtech.mobity.vfc.repository.EfficiencyTargetRepository;
import com.valtech.mobity.vfc.repository.MileageRepository;
import com.valtech.mobity.vfc.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageServiceImpl implements MileageService {

    @Autowired
    private EfficiencyTargetRepository efficiencyTargetRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MileageRepository mileageRepository;

    @Override
    @Transactional
    public NotificationResponseDto setMileage(MileageDetailsRequestDto mileageDetails) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        EfficiencyTarget efficiencyTarget = efficiencyTargetRepository.findByUserIdAndVehicleIdAndStatus(mileageDetails.getUserId(), mileageDetails.getVehicleId(), EfficiencyTargetStatus.ACTIVE).get(0);
        MileageDetails mileageDetailsModel = new MileageDetails();
        mileageDetailsModel.setMileageRange(mileageDetails.getCurrentMileage());
        mileageDetailsModel.setUserId(mileageDetails.getUserId());
        mileageDetailsModel.setVehicleId(mileageDetails.getVehicleId());
        mileageRepository.save(mileageDetailsModel);
        if (mileageDetails.getCurrentMileage() > efficiencyTarget.getEfficientTargetValue()) {
            Notification notification = Notification.builder()
                    .notificationMessage("Goal Achieved! Target Mileage:" + efficiencyTarget.getEfficientTargetValue() + " Current Mileage: " + mileageDetails.getCurrentMileage())
                    .vehicleId(mileageDetails.getVehicleId())
                    .userId(mileageDetails.getUserId())
                    .build();
            notificationResponseDto.setMessage(notification.getNotificationMessage());
            notificationRepository.save(notification);
        } else {
            List<Notification> notifications = notificationRepository.findByUserIdAndVehicleId(mileageDetails.getUserId(), mileageDetails.getVehicleId());
            if (!notifications.isEmpty()) {
                notificationRepository.deleteByUserIdAndVehicleId(mileageDetails.getUserId(), mileageDetails.getVehicleId());
            }
        }
        return notificationResponseDto;
    }

    public List<MileageDetails> getMileageByVehicleIdAndUserId(long vehicleId, long userId) {
        return mileageRepository.findByVehicleIdAndUserId(vehicleId, userId);
    }

    public Double getAverageMileage(Long userId, Long vehicleId) {
        return mileageRepository.findAverageMileageByUserIdAndVehicleId(userId, vehicleId);
    }
}
