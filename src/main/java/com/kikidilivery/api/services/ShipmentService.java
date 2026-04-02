// ShipmentService.java
package com.kikidilivery.api.services;

import com.kikidilivery.api.domain.Shipment;
import com.kikidilivery.api.domain.ShipmentStatus;
import com.kikidilivery.api.dto.ShipmentRequest;
import com.kikidilivery.api.dto.ShipmentResponse;
import com.kikidilivery.api.mappers.DTOMapper;
import com.kikidilivery.api.mappers.ShipmentRequestMapper;
import com.kikidilivery.api.mappers.ShipmentViewMapper;
import com.kikidilivery.api.repos.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    private final DTOMapper<ShipmentRequest, Shipment> requestMapper = new ShipmentRequestMapper();
    private final DTOMapper<Shipment, ShipmentResponse> viewMapper   = new ShipmentViewMapper();
    
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }
    public ShipmentResponse create(ShipmentRequest request) {
        Shipment shipment = requestMapper.map(request);
        return viewMapper.map(shipmentRepository.save(shipment));
    }

    @Transactional(readOnly = true)
    public ShipmentResponse getById(UUID id) {
        return viewMapper.map(findOrThrow(id));
    }

    @Transactional(readOnly = true)
    public List<ShipmentResponse> getAll() {
        return shipmentRepository.findAll().stream()
                .map(viewMapper::map)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ShipmentResponse> getBySender(UUID senderId) {
        return shipmentRepository.findBySenderId(senderId).stream()
                .map(viewMapper::map)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ShipmentResponse> getByReceiver(UUID receiverId) {
        return shipmentRepository.findByReceiverId(receiverId).stream()
                .map(viewMapper::map)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ShipmentResponse> getByStatus(ShipmentStatus status) {
        return shipmentRepository.findByStatus(status).stream()
                .map(viewMapper::map)
                .toList();
    }

    public ShipmentResponse updateStatus(UUID id, ShipmentStatus status) {
        Shipment shipment = findOrThrow(id);
        shipment.setStatus(status);
        // save() 可省略（dirty checking），但显式调用更清晰
        return viewMapper.map(shipmentRepository.save(shipment));
    }

    public ShipmentResponse update(UUID id, ShipmentRequest request) {
        Shipment shipment = findOrThrow(id);
        shipment.setSenderId(request.getSenderId());
        shipment.setReceiverId(request.getReceiverId());
        shipment.setPickupAddress(request.getPickupAddress());
        shipment.setDeliveryAddress(request.getDeliveryAddress());
        return viewMapper.map(shipmentRepository.save(shipment));
    }

    public void delete(UUID id) {
        if (!shipmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Shipment not found: " + id);
        }
        shipmentRepository.deleteById(id);
    }

    // 内部公共方法，供其他 Service 使用（如 TrackingEventService）
    public Shipment findOrThrow(UUID id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found: " + id));
    }
}