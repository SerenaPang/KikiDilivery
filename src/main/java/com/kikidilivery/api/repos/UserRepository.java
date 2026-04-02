package com.kikidilivery.api.repos;

import com.kikidilivery.api.domain.User;
import com.kikidilivery.api.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(UserRole role);

    @Query("SELECT u FROM User u WHERE u.id IN (SELECT t.driverId FROM CourierTask t WHERE t.shipment.id = :shipmentId)")
    List<User> findDriversByShipment(@Param("shipmentId") UUID shipmentId);
}
