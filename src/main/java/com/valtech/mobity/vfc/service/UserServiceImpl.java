package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.UserRequestDto;
import com.valtech.mobity.vfc.model.Users;
import com.valtech.mobity.vfc.model.VehicleDetails;
import com.valtech.mobity.vfc.repository.UsersRepository;
import com.valtech.mobity.vfc.repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;

    @Override
    public Users saveUser(UserRequestDto userRequestDto) {
        Optional<VehicleDetails> vehicleDetails= vehicleDetailsRepository.findById(userRequestDto.getVehicleId());
        if(vehicleDetails.isPresent()) {
            Users user = Users.builder()
                    .name(userRequestDto.getName())
                    .vehicleDetails(vehicleDetails.get())
                    .build();
            return usersRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public Optional<Users> getUserById(Long userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<Users> getUsersByVehicleId(Long vehicleId) {
        return usersRepository.findByVehicleDetails_VehicleId(vehicleId);
    }
}
