package com.kikidilivery.api.domain;

public enum ShipmentStatus {
    PENDING,        // 待取件
    PICKED_UP,      // 已取件
    IN_TRANSIT,     // 运输中
    OUT_FOR_DELIVERY, // 派送中
    DELIVERED,      // 已送达
    FAILED,         // 派送失败
    CANCELLED       // 已取消
}