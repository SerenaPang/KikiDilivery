package com.kikidilivery.api.mappers;

import com.kikidilivery.api.domain.Shipment;
import com.kikidilivery.api.dto.ShipmentResponse;

public class ShipmentViewMapper implements DTOMapper<Shipment, ShipmentResponse> {
    @Override
    public ShipmentResponse map(Shipment shipment) {
        ShipmentResponse response = new ShipmentResponse();
        response.setId(shipment.getId());
        response.setSenderId(shipment.getSenderId());
        response.setReceiverId(shipment.getReceiverId());
        response.setPickupAddress(shipment.getPickupAddress());
        response.setDeliveryAddress(shipment.getDeliveryAddress());
        response.setStatus(shipment.getStatus());
        return response;
    }
}