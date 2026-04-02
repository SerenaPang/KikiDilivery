package com.kikidilivery.api.rest;

import com.kikidilivery.api.dto.TrackingEventRequest;
import com.kikidilivery.api.dto.TrackingEventResponse;
import com.kikidilivery.api.services.TrackingEventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tracking-events")
@Tag(name = "Tracking Events", description = "Tracking event management APIs")
public class TrackingEventController {

    private final TrackingEventService trackingEventService;

    public TrackingEventController(TrackingEventService trackingEventService) {
        this.trackingEventService = trackingEventService;
    }

    @PostMapping
    @Operation(
            summary = "Create a new tracking event",
            description = "Create a tracking event and update shipment status"
    )
    public ResponseEntity<TrackingEventResponse> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Tracking event request payload",
                    required = true
            )
            @RequestBody TrackingEventRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trackingEventService.create(request));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get tracking event by ID",
            description = "Retrieve a specific tracking event using its UUID"
    )
    public ResponseEntity<TrackingEventResponse> getById(
            @Parameter(description = "Tracking event ID", required = true)
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(trackingEventService.getById(id));
    }

    @GetMapping("/shipment/{shipmentId}")
    @Operation(
            summary = "Get tracking events by shipment ID",
            description = "Retrieve all tracking events for a shipment in descending order"
    )
    public ResponseEntity<List<TrackingEventResponse>> getByShipmentId(
            @Parameter(description = "Shipment ID", required = true)
            @PathVariable UUID shipmentId
    ) {
        return ResponseEntity.ok(trackingEventService.getByShipmentId(shipmentId));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete tracking event",
            description = "Delete a tracking event by its ID"
    )
    public ResponseEntity<Void> delete(
            @Parameter(description = "Tracking event ID", required = true)
            @PathVariable UUID id
    ) {
        trackingEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}