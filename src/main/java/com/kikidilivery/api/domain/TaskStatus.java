package com.kikidilivery.api.domain;

public enum TaskStatus {
    ASSIGNED,       // assign to driver
    ACCEPTED,       // driver accepted
    EN_ROUTE_PICKUP,   // driver picked up package
    PICKED_UP,      // picked up package
    EN_ROUTE_DELIVERY, // out for dilivery
    COMPLETED,      // dilivery compelted
    FAILED,         // dilivery failed
    CANCELLED       // dilivery cancelled
}