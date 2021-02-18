package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisanRepo extends JpaRepository<Artisan,Long> {
    Artisan findByCodePersonne(long codeArtisan);
    Artisan findByEmailPersonne(String email);
}
