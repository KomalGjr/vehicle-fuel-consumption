package com.valtech.mobity.vfc.model;

public enum EfficiencyTargetStatus {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    EfficiencyTargetStatus(int value) {
        this.value = value;
    }

    public static EfficiencyTargetStatus fromValue(int value) {
        for (EfficiencyTargetStatus status : EfficiencyTargetStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }

    public int getValue() {
        return value;
    }
}
