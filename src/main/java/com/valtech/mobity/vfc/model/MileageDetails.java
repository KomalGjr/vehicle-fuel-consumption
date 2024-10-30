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
@Table(name = "mileage_details")
public class MileageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mileageId;

    private Double mileageRange;

    private long userId;

    private long vehicleId;
}
