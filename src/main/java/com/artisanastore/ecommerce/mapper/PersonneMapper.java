package com.artisanastore.ecommerce.mapper;

import com.artisanastore.ecommerce.Domaine.PersonneVO;
import com.artisanastore.ecommerce.Models.Personne;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMapper extends EntityMapper<Personne , PersonneVO>{
}
