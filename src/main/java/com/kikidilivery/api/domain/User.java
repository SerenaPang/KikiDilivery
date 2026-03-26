package com.kikidilivery.api.domain;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "sender")
    private Set<Shipment> sentShipments;

    @OneToMany(mappedBy = "receiver")
    private Set<Shipment> receivedShipments;
}