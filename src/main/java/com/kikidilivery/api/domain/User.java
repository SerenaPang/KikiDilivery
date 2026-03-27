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

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @OneToMany(mappedBy = "sender")
    private Set<Shipment> sentShipments;

    @OneToMany(mappedBy = "receiver")
    private Set<Shipment> receivedShipments;

    @OneToMany(mappedBy = "driver")
    private Set<CourierTask> assignedTasks;

    // getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }

    public Set<Shipment> getSentShipments() { return sentShipments; }
    public void setSentShipments(Set<Shipment> sentShipments) { this.sentShipments = sentShipments; }

    public Set<Shipment> getReceivedShipments() { return receivedShipments; }
    public void setReceivedShipments(Set<Shipment> receivedShipments) { this.receivedShipments = receivedShipments; }

    public Set<CourierTask> getAssignedTasks() { return assignedTasks; }
    public void setAssignedTasks(Set<CourierTask> assignedTasks) { this.assignedTasks = assignedTasks; }
}