package com.kikidilivery.api.domain;
import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "courier_tasks")
public class CourierTask {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

  @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
