package com.kikidilivery.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Shipment status enum")
public enum ShipmentStatus {
    CREATED,
    IN_TRANSIT,
    DELIVERED,
    CANCELLED
}