package com.kikidilivery.api.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kikidilivery.api.domain.Shipment;

public interface ShipmentRepository extends CrudRepository<Shipment, UUID> {}