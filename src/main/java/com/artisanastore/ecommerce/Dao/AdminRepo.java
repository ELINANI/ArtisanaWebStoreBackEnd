package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByCodePersonne(long codeAdmin);
}
