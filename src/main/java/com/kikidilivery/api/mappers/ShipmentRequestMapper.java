package com.kikidilivery.api.mappers;

import com.kikidilivery.api.domain.Shipment;
import com.kikidilivery.api.domain.ShipmentStatus;
import com.kikidilivery.api.dto.ShipmentRequest;

// ShipmentRequestMapper.java
public class ShipmentRequestMapper implements DTOMapper<ShipmentRequest, Shipment> {
    @Override
    public Shipment map(ShipmentRequest request) {
        Shipment shipment = new Shipment();
        shipment.setSenderId(request.getSenderId());
        shipment.setReceiverId(request.getReceiverId());
        shipment.setPickupAddress(request.getPickupAddress());
        shipment.setDeliveryAddress(request.getDeliveryAddress());
        shipment.setStatus(ShipmentStatus.IN_TRANSIT);
        return shipment;
    }
}