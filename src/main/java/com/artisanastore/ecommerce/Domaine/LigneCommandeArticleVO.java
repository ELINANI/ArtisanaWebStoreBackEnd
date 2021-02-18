package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Article;
import com.artisanastore.ecommerce.Models.Commande;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class LigneCommandeArticleVO  implements Serializable {
    private long codeLignCommandeArticle;

    private int qtecodeLignCommandeArticle;
    private CommandeVO commandeLigne = new CommandeVO();
    private ArticleVO article = new ArticleVO();

    public LigneCommandeArticleVO(long codeLignCommandeArticle,int qtecodeLignCommandeArticle , CommandeVO commandeLigne , ArticleVO article) {
        this.codeLignCommandeArticle = codeLignCommandeArticle;
        this.qtecodeLignCommandeArticle =qtecodeLignCommandeArticle ;
        this.commandeLigne = commandeLigne;
        this.article = article;
    }
}
