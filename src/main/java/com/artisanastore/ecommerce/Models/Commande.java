package com.artisanastore.ecommerce.Models;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
public class Commande  implements Serializable {

    @Id
    @GeneratedValue
    private long codeCommande;
    private String dateCommande;

    @ManyToOne
    @JoinColumn(name = "CommandeClient")
    private Client client;


    @OneToOne(mappedBy = "commande" , cascade = CascadeType.ALL)

    private Validation validation;

    @OneToMany(mappedBy = "commandeLigne")
    @Basic(fetch = FetchType.LAZY)
    private List<LignCommandeArticle> lignCommandeArticle = new ArrayList<LignCommandeArticle>();

    public Commande(String dateCommande , Client client , Validation validation ,List<LignCommandeArticle> lignCommandeArticle) {
        this.dateCommande = dateCommande;
    }

    public void addLignCommandeArticle(LignCommandeArticle l){
        l.setCommandeLigne(this);
        lignCommandeArticle.add(l);
    }
}
