package com.kikidilivery.api.dto;

import java.util.UUID;

import com.kikidilivery.api.domain.TaskStatus;

public class CourierTaskResponse {
    private UUID id;
    private UUID shipmentId;
    private UUID driverId;
    private TaskStatus status;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getShipmentId() {
        return shipmentId;
    }
    public void setShipmentId(UUID shipmentId) {
        this.shipmentId = shipmentId;
    }
    public UUID getDriverId() {
        return driverId;
    }
    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
