package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.UserRequestDto;
import com.valtech.mobity.vfc.dto.UserResponseDto;
import com.valtech.mobity.vfc.model.Users;
import com.valtech.mobity.vfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Map<Integer, List<UserResponseDto>> VEHICLE_USERS_MAPPING = new HashMap<>();

    static {
        VEHICLE_USERS_MAPPING.put(1, List.of(new UserResponseDto(1, "John"), new UserResponseDto(2, "George")));
        VEHICLE_USERS_MAPPING.put(2, List.of(new UserResponseDto(3, "Paul"), new UserResponseDto(4, "Ringo")));
    }

    @GetMapping("/test")
    public List<UserResponseDto> getUsersForVehicle(@RequestParam(name = "vehicleId") Integer vehicleId) {
        return VEHICLE_USERS_MAPPING.get(vehicleId);
    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody UserRequestDto userRequestDto) {
        Users savedUser = userService.saveUser(userRequestDto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Users>> getUsersByVehicleId(@PathVariable Long vehicleId) {
        List<Users> users = userService.getUsersByVehicleId(vehicleId);
        return ResponseEntity.ok(users);
    }
}
