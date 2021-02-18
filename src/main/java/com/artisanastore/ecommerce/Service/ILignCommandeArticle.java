package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.LigneCommandeArticleVO;

import java.util.List;

public interface ILignCommandeArticle {
    List<LigneCommandeArticleVO> getAllLignCommandeArticle();
    void addLignCommandeArticle(LigneCommandeArticleVO ligneCommandeArticleVO);
    void updateLignCommandeArticle(long codeLignCommandeArticle,LigneCommandeArticleVO ligneCommandeArticleVO);
    void deleteLignCommandeArticle(long codeLignCommandeArticle);
    LigneCommandeArticleVO findByCodeLignCommandeArticle(long codeLigneCommandeArticleVO);
}
