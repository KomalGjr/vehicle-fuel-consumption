package com.valtech.mobity.vfc.dto;

import lombok.Data;

@Data
public class NotificationRequestDto {

    private String notificationMessage;

    private String status;//open,closed

    private long userId;

    private String vehicleId;
}
