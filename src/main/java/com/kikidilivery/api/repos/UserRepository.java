package com.kikidilivery.api.repos;

import com.kikidilivery.api.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    // searching for driver for one specific shipment
    @Query("""
            SELECT u FROM User u 
            JOIN u.assignedTasks t 
            WHERE t.shipment.id = :shipmentId
            """)
    List<User> findDriversByShipment(UUID shipmentId);

    // looking for user by role
    List<User> findByRole(String role);
}