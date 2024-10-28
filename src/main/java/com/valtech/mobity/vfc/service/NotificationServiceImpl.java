package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.model.Notification;
import com.valtech.mobity.vfc.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserIdAndVehicleId(Long userId, long vehicleId) {
        return notificationRepository.findByUserIdAndVehicleId(userId, vehicleId);
    }

    @Override
    public void deleteNotification(Long userId, long vehicleId) {
        notificationRepository.deleteByUserIdAndVehicleId(userId, vehicleId);
    }
}
