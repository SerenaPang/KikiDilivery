package com.kikidilivery.api.dto;

import java.util.UUID;

public class ShipmentRequest {
    private UUID senderId;
    private UUID receiverId;
    private String pickupAddress;
    private String deliveryAddress;
    public UUID getSenderId() {
        return senderId;
    }
    public UUID getReceiverId() {
        return receiverId;
    }
    public String getPickupAddress() {
        return pickupAddress;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }
    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }
    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }    
}
