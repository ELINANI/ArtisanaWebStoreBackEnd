package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Client;
import com.artisanastore.ecommerce.Models.LignCommandeArticle;
import com.artisanastore.ecommerce.Models.Validation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class CommandeVO  implements Serializable {
    private long codeCommande;
    private String dateCommande;
    private ClientVO client = new ClientVO();
    private ValidationVO validation = new ValidationVO();
    private List<LigneCommandeArticleVO> lignCommandeArticle = new ArrayList<LigneCommandeArticleVO>();

    public CommandeVO(long codeCommande,String dateCommande ,ClientVO client ,  ValidationVO validation
     ,List<LigneCommandeArticleVO> lignCommandeArticle  ) {
        this.codeCommande = codeCommande;
        this.dateCommande = dateCommande;
        this.client = client;
        this.validation = validation;
        this.lignCommandeArticle = lignCommandeArticle;

    }
}
