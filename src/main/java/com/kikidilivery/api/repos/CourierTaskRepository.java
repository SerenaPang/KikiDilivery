package com.kikidilivery.api.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kikidilivery.api.domain.CourierTask;

public interface CourierTaskRepository extends CrudRepository<CourierTask, UUID> {}