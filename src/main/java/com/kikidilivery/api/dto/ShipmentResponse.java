package com.kikidilivery.api.dto;

import java.util.UUID;

import com.kikidilivery.api.domain.ShipmentStatus;

public class ShipmentResponse {
    private UUID id;
    private UUID senderId;
    private UUID receiverId;
    private String pickupAddress;
    private String deliveryAddress;
    private ShipmentStatus status;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getSenderId() {
        return senderId;
    }
    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }
    public UUID getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }
    public String getPickupAddress() {
        return pickupAddress;
    }
    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public ShipmentStatus getStatus() {
        return status;
    }
    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }
}