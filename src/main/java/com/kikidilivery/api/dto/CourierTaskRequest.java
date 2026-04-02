package com.kikidilivery.api.dto;

import java.util.UUID;

public class CourierTaskRequest {
    private UUID shipmentId;
    private UUID driverId;
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
}