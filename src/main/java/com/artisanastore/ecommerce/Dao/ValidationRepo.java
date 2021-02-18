package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepo extends JpaRepository<Validation,Long> {
    Validation findByCodeValidation(long CodeValidation);
}
