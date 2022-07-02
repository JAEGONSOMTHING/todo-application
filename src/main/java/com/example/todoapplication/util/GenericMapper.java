package com.example.todoapplication.util;


import org.mapstruct.*;


public interface GenericMapper<D, E> {
    E toEntity(D Dto);
    D toDto(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D dto, @MappingTarget E entity);











}
