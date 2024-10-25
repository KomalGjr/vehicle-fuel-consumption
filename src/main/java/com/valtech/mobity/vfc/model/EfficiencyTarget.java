package com.valtech.mobity.vfc.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EfficiencyTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long efficientTargetId;

    private Double efficientTargetValue;

    private String status;

    private String userId;

    private String vehicleId;
}
