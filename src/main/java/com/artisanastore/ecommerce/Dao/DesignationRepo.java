package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation,Long> {
    Designation findByCodeDesignation(long codeDesignation);
}
