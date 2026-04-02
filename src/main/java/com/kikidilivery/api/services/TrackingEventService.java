package com.kikidilivery.api.services;

import com.kikidilivery.api.domain.Shipment;
import com.kikidilivery.api.domain.TrackingEvent;
import com.kikidilivery.api.dto.TrackingEventRequest;
import com.kikidilivery.api.dto.TrackingEventResponse;
import com.kikidilivery.api.mappers.DTOMapper;
import com.kikidilivery.api.mappers.TrackingEventRequestMapper;
import com.kikidilivery.api.mappers.TrackingEventViewMapper;
import com.kikidilivery.api.repos.TrackingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TrackingEventService {

    private final TrackingRepository trackingRepository;
    private final ShipmentService shipmentService;

    private final DTOMapper<TrackingEventRequest, TrackingEvent> requestMapper = new TrackingEventRequestMapper();
    private final DTOMapper<TrackingEvent, TrackingEventResponse> viewMapper   = new TrackingEventViewMapper();

    public TrackingEventService(TrackingRepository trackingRepository,
                                ShipmentService shipmentService) {
        this.trackingRepository = trackingRepository;
        this.shipmentService    = shipmentService;
    }

    public TrackingEventResponse create(TrackingEventRequest request) {
        // 1. 验证 shipment 存在
        Shipment shipment = shipmentService.findOrThrow(request.getShipmentId());

        // 2. 映射并设置关联
        TrackingEvent event = requestMapper.map(request);
        event.setShipment(shipment);

        // 3. 同步更新包裹状态为最新事件状态
        shipment.setStatus(request.getStatus());

        return viewMapper.map(trackingRepository.save(event));
    }

    @Transactional(readOnly = true)
    public TrackingEventResponse getById(UUID id) {
        return viewMapper.map(findOrThrow(id));
    }

    @Transactional(readOnly = true)
    public List<TrackingEventResponse> getByShipmentId(UUID shipmentId) {
        shipmentService.findOrThrow(shipmentId); // 确认包裹存在
        return trackingRepository
                .findByShipmentIdOrderByEventTimeDesc(shipmentId)
                .stream()
                .map(viewMapper::map)
                .toList();
    }

    public void delete(UUID id) {
        if (!trackingRepository.existsById(id)) {
            throw new EntityNotFoundException("TrackingEvent not found: " + id);
        }
        trackingRepository.deleteById(id);
    }

    private TrackingEvent findOrThrow(UUID id) {
        return trackingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TrackingEvent not found: " + id));
    }
}