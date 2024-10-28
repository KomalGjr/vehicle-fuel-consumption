package com.valtech.mobity.vfc.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "efficiency_target")
public class EfficiencyTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long efficientTargetId;

    private Double efficientTargetValue;

    @Enumerated(EnumType.STRING) // Store as a string in the database
    private EfficiencyTargetStatus status;

    private long userId;

    private long vehicleId;
}
