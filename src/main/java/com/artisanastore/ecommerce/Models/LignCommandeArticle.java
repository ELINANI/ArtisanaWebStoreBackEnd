package com.artisanastore.ecommerce.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class LignCommandeArticle implements Serializable {

     @Id
    @GeneratedValue
   private long codeLignCommandeArticle;

     private int qtecodeLignCommandeArticle;

      @ManyToOne
      @JoinColumn(name = "commandeligne")
      private Commande commandeLigne ;


    @ManyToOne
    @JoinColumn(name = "article_ligne")
    private Article article;



    public LignCommandeArticle(int qtecodeLignCommandeArticle , Commande commandeLigne , Article article) {
        this.qtecodeLignCommandeArticle =qtecodeLignCommandeArticle ;

    }

}
