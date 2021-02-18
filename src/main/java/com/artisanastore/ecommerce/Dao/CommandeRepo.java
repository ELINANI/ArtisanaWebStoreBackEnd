package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo extends JpaRepository<Commande,Long> {
    Commande findByCodeCommande(long codeCommande);
}
