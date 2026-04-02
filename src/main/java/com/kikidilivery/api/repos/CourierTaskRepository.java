package com.kikidilivery.api.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kikidilivery.api.domain.CourierTask;
import com.kikidilivery.api.domain.TaskStatus;
@Repository
public interface CourierTaskRepository extends CrudRepository<CourierTask, UUID> {
    List<CourierTask> findByDriverId(UUID driverId);

    List<CourierTask> findByShipmentId(UUID shipmentId);

    List<CourierTask> findByStatus(TaskStatus status);

    List<CourierTask> findByDriverIdAndStatus(UUID driverId, TaskStatus status);
}