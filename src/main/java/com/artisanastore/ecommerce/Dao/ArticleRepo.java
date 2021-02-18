package com.artisanastore.ecommerce.Dao;

import com.artisanastore.ecommerce.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Long> {
    Article findByCodeArticle(long codeArticle);
}
