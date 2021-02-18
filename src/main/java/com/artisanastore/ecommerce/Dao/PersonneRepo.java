package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne,Long> {
    Personne findByEmailPersonne(String email);
}
