package com.valtech.mobity.vfc.repository;

import com.valtech.mobity.vfc.model.MileageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MileageRepository extends JpaRepository<MileageDetails, Long> {
    List<MileageDetails> findByVehicleIdAndUserId(long vehicleId, long userId);

    @Query("SELECT AVG(m.mileageRange) FROM MileageDetails m WHERE m.userId = :userId AND m.vehicleId = :vehicleId")
    Double findAverageMileageByUserIdAndVehicleId(@Param("userId") Long userId, @Param("vehicleId") Long vehicleId);

}
