package com.kikidilivery.api.repos;

import com.kikidilivery.api.domain.Shipment;
import com.kikidilivery.api.domain.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

    List<Shipment> findBySenderId(UUID senderId);

    List<Shipment> findByReceiverId(UUID receiverId);

    List<Shipment> findByStatus(ShipmentStatus status);

    @Query("SELECT s FROM Shipment s LEFT JOIN FETCH s.trackingEvents WHERE s.id = :id")
    Optional<Shipment> findByIdWithEvents(@Param("id") UUID id);

    @Query("SELECT s FROM Shipment s LEFT JOIN FETCH s.courierTasks WHERE s.id = :id")
    Optional<Shipment> findByIdWithTasks(@Param("id") UUID id);
}