package com.kikidilivery.api.domain;

import jakarta.persistence.*;
import java.util.UUID;

// CourierTask. has setters and getters for shipment, driver, and status 
@Entity
@Table(name = "courier_tasks")
public class CourierTask {

  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipment_id")
  private Shipment shipment;

  @Column(name = "driver_id")
  private UUID driverId;

  @Enumerated(EnumType.STRING)
  private TaskStatus status;

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