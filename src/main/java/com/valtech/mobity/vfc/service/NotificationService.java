package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.model.Notification;

import java.util.List;

public interface NotificationService {
    public Notification saveNotification(Notification notification);
    public List<Notification> getNotificationsByUserIdAndVehicleId(Long userId, long vehicleId);
    public void deleteNotification(Long userId, long vehicleId);
}
