package com.kikidilivery.api.mappers;

import com.kikidilivery.api.domain.TrackingEvent;
import com.kikidilivery.api.dto.TrackingEventResponse;

public class TrackingEventViewMapper implements DTOMapper<TrackingEvent, TrackingEventResponse> {
    @Override
    public TrackingEventResponse map(TrackingEvent event) {
        TrackingEventResponse response = new TrackingEventResponse();
        response.setId(event.getId().toString());
        response.setShipmentId(event.getShipment().getId().toString());
        response.setLocation(event.getLocation());
        response.setStatus(event.getStatus());
        response.setEventTime(event.getEventTime());
        return response;
    }
}