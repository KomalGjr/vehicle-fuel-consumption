package com.valtech.mobity.vfc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "vehicle_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private String manufacturer;

    private String model;

//    private Set<EfficiencyTarget> efficiencyTargets;
}
