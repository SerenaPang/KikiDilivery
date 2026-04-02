package com.kikidilivery.api.mappers;

@FunctionalInterface
public interface DTOMapper<Input, Output> {
    Output map(Input obj);
}