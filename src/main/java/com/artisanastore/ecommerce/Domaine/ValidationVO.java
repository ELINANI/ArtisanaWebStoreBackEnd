package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Artisan;
import com.artisanastore.ecommerce.Models.Commande;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class ValidationVO  implements Serializable {
    private long codeValidation ;
    private String dateAjoutCommande;
    private String dateAjoutValidation;
    private ArtisanVO artisan = new ArtisanVO();
    private CommandeVO commande = new CommandeVO();

    public ValidationVO(long codeValidation,String dateAjoutCommande, String dateAjoutValidation ,ArtisanVO artisan , CommandeVO commande) {
       this.codeValidation = codeValidation;
        this.dateAjoutCommande = dateAjoutCommande;
        this.dateAjoutValidation = dateAjoutValidation;
        this.artisan = artisan;
        this.commande = commande;

    }
}
