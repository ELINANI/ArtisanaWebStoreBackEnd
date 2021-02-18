package com.artisanastore.ecommerce.mapper;

import java.util.List;

public interface EntityMapper<E,D> {
    E toEntity(D dto);
    // @Mapping(target="file", ignore=true)
    D toDto(E entity);
    List<E> toEntity(List<D> listDto);
    List<D> toDto(List<E> listEntity);

}
