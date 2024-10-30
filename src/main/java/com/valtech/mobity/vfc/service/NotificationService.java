package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification saveNotification(Notification notification);

    List<Notification> getNotificationsByUserIdAndVehicleId(Long userId, long vehicleId);

    void deleteNotification(Long userId, long vehicleId);
}
