package com.valtech.mobity.vfc.repository;

import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.model.EfficiencyTargetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EfficiencyTargetRepository extends JpaRepository<EfficiencyTarget, Long> {

    List<EfficiencyTarget> findByUserIdAndVehicleIdAndStatus(long userId, long vehicleId, EfficiencyTargetStatus status);

}
