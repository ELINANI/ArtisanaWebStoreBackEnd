package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoutiqueRepo extends JpaRepository<Boutique,Long> {
    Boutique findByCodeBoutique(long codeBoutique);
}
