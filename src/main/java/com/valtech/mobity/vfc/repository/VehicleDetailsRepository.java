package com.valtech.mobity.vfc.repository;

import com.valtech.mobity.vfc.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Long> {

}
