package com.kikidilivery.api.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kikidilivery.api.domain.TrackingEvent;

public interface TrackingRepository extends CrudRepository<TrackingEvent, UUID> {}