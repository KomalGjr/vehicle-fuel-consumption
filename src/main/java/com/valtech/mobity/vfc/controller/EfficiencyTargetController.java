package com.valtech.mobity.vfc.controller;

import com.valtech.mobity.vfc.dto.EfficiencyTargetRequestDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.service.EfficiencyTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/efficiency-targets")
@CrossOrigin(originPatterns = "*")
public class EfficiencyTargetController {

    @Autowired
    private EfficiencyTargetService efficiencyTargetService;

    // Save API
    @PostMapping
    public ResponseEntity<EfficiencyTarget> saveEfficiencyTarget(@RequestBody EfficiencyTargetRequestDto requestDto) {
        EfficiencyTarget savedTarget = efficiencyTargetService.saveEfficiencyTarget(requestDto);
        return ResponseEntity.ok(savedTarget);
    }

    // Get API based on userId and vehicleId
    @GetMapping("/user/{userId}/vehicle/{vehicleId}")
    public ResponseEntity<EfficiencyTarget> getEfficiencyTargetsByUserIdAndVehicleId(
            @PathVariable long userId, @PathVariable long vehicleId) {
        EfficiencyTarget target = efficiencyTargetService.getEfficiencyTargetsByUserIdAndVehicleId(userId, vehicleId);
        return ResponseEntity.ok(target);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEfficiencyTarget(@PathVariable Long id) {
        efficiencyTargetService.deleteEfficiencyTarget(id);
        return ResponseEntity.noContent().build();
    }
}
