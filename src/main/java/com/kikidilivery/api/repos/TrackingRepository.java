// TrackingRepository.java
package com.kikidilivery.api.repos;

import com.kikidilivery.api.domain.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrackingRepository extends JpaRepository<TrackingEvent, UUID> {

    List<TrackingEvent> findByShipmentIdOrderByEventTimeDesc(UUID shipmentId);

    @Modifying
    @Query("DELETE FROM TrackingEvent t WHERE t.shipment.id = :shipmentId")
    void deleteByShipmentId(@Param("shipmentId") UUID shipmentId);
}