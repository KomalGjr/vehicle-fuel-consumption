package com.valtech.mobity.vfc.repository;

import com.valtech.mobity.vfc.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findByVehicleDetails_VehicleId(Long vehicleId);

}
