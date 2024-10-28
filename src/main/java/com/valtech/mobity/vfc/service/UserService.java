package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.UserRequestDto;
import com.valtech.mobity.vfc.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Users saveUser(UserRequestDto userRequestDto);
    Optional<Users> getUserById(Long userId);
    List<Users> getAllUsers();
    List<Users> getUsersByVehicleId(Long vehicleId);

}
