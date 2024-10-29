package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.MileageDetails;
import com.valtech.mobity.vfc.dto.NotificationResponseDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.model.EfficiencyTargetStatus;
import com.valtech.mobity.vfc.model.Notification;
import com.valtech.mobity.vfc.repository.EfficiencyTargetRepository;
import com.valtech.mobity.vfc.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageServiceImpl implements MileageService{

    @Autowired
    private EfficiencyTargetRepository efficiencyTargetRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationResponseDto setMileage(MileageDetails mileageDetails) {
        NotificationResponseDto notificationResponseDto =  new NotificationResponseDto();
        EfficiencyTarget efficiencyTarget = efficiencyTargetRepository.findByUserIdAndVehicleIdAndStatus(mileageDetails.getUserId(),mileageDetails.getVehicleId(), EfficiencyTargetStatus.ACTIVE).get(0);
        if(mileageDetails.getCurrentMileage() > efficiencyTarget.getEfficientTargetValue()){
            Notification notification = Notification.builder()
                    .notificationMessage("The mileage speed has exceeded the set efficient target: "+ efficiencyTarget.getEfficientTargetValue())
                    .vehicleId(mileageDetails.getVehicleId())
                    .userId(mileageDetails.getUserId())
                    .build();
            notificationResponseDto.setMessage(notification.getNotificationMessage());
            notificationRepository.save(notification);
        }else{
            List<Notification> notifications = notificationRepository.findByUserIdAndVehicleId(mileageDetails.getUserId(),mileageDetails.getVehicleId());
            if(!notifications.isEmpty()){
                notificationRepository.deleteByUserIdAndVehicleId(mileageDetails.getUserId(),mileageDetails.getVehicleId());
            }
        }
        return notificationResponseDto;
    }
}
