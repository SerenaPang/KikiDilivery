package com.kikidilivery.api.mappers;

import com.kikidilivery.api.domain.TrackingEvent;
import com.kikidilivery.api.dto.TrackingEventRequest;

public class TrackingEventRequestMapper implements DTOMapper<TrackingEventRequest, TrackingEvent> {
    @Override
    public TrackingEvent map(TrackingEventRequest request) {
        TrackingEvent event = new TrackingEvent();
        event.setLocation(request.getLocation());
        event.setStatus(request.getStatus());
        event.setEventTime(request.getEventTime());
        // shipment 在 Service 层通过 shipmentId 查询后 set
        return event;
    }
}