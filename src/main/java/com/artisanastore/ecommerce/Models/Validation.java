package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
public class Validation implements Serializable {
      @Id
      @GeneratedValue
      private long codeValidation ;
      private String dateAjoutCommande;
      private String dateAjoutValidation;


      @ManyToOne
      @JoinColumn(name = "artisanValidation")
      private  Artisan artisan;

       @OneToOne
       @JoinColumn(name = "commandeValidation")
       private Commande commande;


      public Validation(String dateAjoutCommande, String dateAjoutValidation , Artisan artisan , Commande commande) {
            this.dateAjoutCommande = dateAjoutCommande;
            this.dateAjoutValidation = dateAjoutValidation;
      }
}
