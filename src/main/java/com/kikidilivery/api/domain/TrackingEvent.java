package com.kikidilivery.api.domain;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;


// TrackingEvent has all getters and setters for the shipment id, location, event time
@Entity
@Table(name = "tracking_events")
public class TrackingEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private String location;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @Column(name = "event_time")
    private OffsetDateTime eventTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
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