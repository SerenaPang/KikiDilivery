package com.kikidilivery.api.domain;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String pickupAddress;
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<TrackingEvent> trackingEvents;
}