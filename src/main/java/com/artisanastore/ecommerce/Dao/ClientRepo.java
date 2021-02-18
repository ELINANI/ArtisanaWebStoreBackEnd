package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
    Client findByCodePersonne(long codeClient);
    Client findByEmailPersonne(String email);
}
