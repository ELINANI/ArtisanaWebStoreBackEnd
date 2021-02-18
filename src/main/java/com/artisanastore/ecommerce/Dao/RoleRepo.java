package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByCodeRole(long codeRole);
    Role findByNomRole(String nomRole);
}
