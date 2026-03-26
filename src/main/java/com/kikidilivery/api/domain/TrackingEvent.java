package com.kikidilivery.api.domain;
import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tracking_events")
public class TrackingEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private String location;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    private OffsetDateTime eventTime;
}