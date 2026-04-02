package com.kikidilivery.api.dto;

import com.kikidilivery.api.domain.ShipmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.UUID;

@Schema(description = "Request payload for creating a tracking event")
public class TrackingEventRequest {

    @Schema(description = "Shipment ID associated with this tracking event", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", required = true)
    private UUID shipmentId;

    @Schema(description = "Location where the event occurred", example = "San Francisco, CA", required = true)
    private String location;

    @Schema(description = "Current shipment status", example = "IN_TRANSIT", required = true)
    private ShipmentStatus status;

    @Schema(description = "Timestamp of the event (ISO 8601 format)", example = "2026-03-30T10:15:30+00:00", required = true)
    private OffsetDateTime eventTime;

    public UUID getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(UUID shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public OffsetDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(OffsetDateTime eventTime) {
        this.eventTime = eventTime;
    }
}