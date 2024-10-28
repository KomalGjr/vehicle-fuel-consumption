package com.valtech.mobity.vfc.service;

import com.valtech.mobity.vfc.dto.EfficiencyTargetRequestDto;
import com.valtech.mobity.vfc.model.EfficiencyTarget;
import com.valtech.mobity.vfc.model.EfficiencyTargetStatus;
import com.valtech.mobity.vfc.repository.EfficiencyTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EfficiencyTargetServiceImpl implements EfficiencyTargetService {

    @Autowired
    private EfficiencyTargetRepository efficiencyTargetRepository;

    @Override
    public EfficiencyTarget saveEfficiencyTarget(EfficiencyTargetRequestDto requestDto) {
        List<EfficiencyTarget> existingTargets = efficiencyTargetRepository
                .findByUserIdAndVehicleIdAndStatus(
                        requestDto.getUserId(),
                        requestDto.getVehicleId(),
                        EfficiencyTargetStatus.ACTIVE
                );

        if (!existingTargets.isEmpty() && requestDto.getStatus() == 1) {
            throw new IllegalStateException("An active efficiency target already exists for this user and vehicle.");
        }
        // Create a new EfficiencyTarget since no active target exists
        EfficiencyTarget efficiencyTarget = EfficiencyTarget.builder()
                .efficientTargetValue(requestDto.getEfficientTargetValue())
                .status(EfficiencyTargetStatus.fromValue(requestDto.getStatus()))
                .userId(requestDto.getUserId())
                .vehicleId(requestDto.getVehicleId())
                .build();

        return efficiencyTargetRepository.save(efficiencyTarget);
    }

    @Override
    public Optional<EfficiencyTarget> getEfficiencyTargetById(Long id) {
        return efficiencyTargetRepository.findById(id);
    }

    @Override
    public EfficiencyTarget getEfficiencyTargetsByUserIdAndVehicleId(long userId, long vehicleId) {
        return efficiencyTargetRepository.findByUserIdAndVehicleIdAndStatus(userId, vehicleId, EfficiencyTargetStatus.ACTIVE).get(0);
    }

    @Override
    public void deleteEfficiencyTarget(Long id) {
        efficiencyTargetRepository.deleteById(id);
    }
}