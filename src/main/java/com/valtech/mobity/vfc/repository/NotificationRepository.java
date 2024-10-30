package com.valtech.mobity.vfc.repository;

import com.valtech.mobity.vfc.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdAndVehicleId(Long userId, long vehicleId);

    void deleteByUserIdAndVehicleId(Long userId, long vehicleId);
}