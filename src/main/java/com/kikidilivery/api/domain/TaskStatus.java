package com.kikidilivery.api.domain;

public enum TaskStatus {
    ASSIGNED,       // 已分配给司机
    ACCEPTED,       // 司机已接单
    EN_ROUTE_PICKUP,   // 前往取件
    PICKED_UP,      // 已取件
    EN_ROUTE_DELIVERY, // 前往送件
    COMPLETED,      // 完成
    FAILED,         // 失败
    CANCELLED       // 取消
}