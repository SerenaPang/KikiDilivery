package com.kikidilivery.api.dto;

import com.kikidilivery.api.domain.ShipmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

@Schema(description = "Response object representing a tracking event")
public class TrackingEventResponse {

    @Schema(
            description = "Tracking event ID",
            example = "f47ac10b-58cc-4372-a567-0e02b2c3d479"
    )
    private String id;

    @Schema(
            description = "Shipment ID associated with this event",
            example = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
    )
    private String shipmentId;

    @Schema(
            description = "Location of the event",
            example = "Los Angeles, CA"
    )
    private String location;

    @Schema(
            description = "Shipment status at this event",
            example = "DELIVERED"
    )
    private ShipmentStatus status;

    @Schema(
            description = "Event timestamp (ISO 8601 format)",
            example = "2026-03-30T10:15:30+00:00"
    )
    private OffsetDateTime eventTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
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