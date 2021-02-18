package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Data

public class Boutique  implements Serializable {

    @Id
    @GeneratedValue
    private long codeBoutique;
    private String dateCreationBoutique;

    public Boutique(String dateCreationBoutique,Artisan artisan , List<Article> articleList) {
        this.dateCreationBoutique = dateCreationBoutique;

    }

    @ManyToOne
    @JoinColumn(name = "artisanBoutique")
    private Artisan artisan ;

     @ManyToMany(mappedBy = "boutiqueList")
     @Basic(fetch = FetchType.LAZY)
     private List<Article> articleList = new ArrayList<Article>();

    public void addArticle(Article art){
        art.AddBoutique(this);
        articleList.add(art);
    }
}
