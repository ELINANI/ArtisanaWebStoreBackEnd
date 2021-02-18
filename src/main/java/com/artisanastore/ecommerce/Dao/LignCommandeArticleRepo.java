package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.LignCommandeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LignCommandeArticleRepo extends JpaRepository<LignCommandeArticle,Long> {
    LignCommandeArticle findByCodeLignCommandeArticle(long codeLignCommandeArticle);
}
