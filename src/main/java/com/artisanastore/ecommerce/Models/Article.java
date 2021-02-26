package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity

public class Article implements Serializable {
     @Id
    @GeneratedValue
    private long codeArticle;
    private String description;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageCommandeView;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageCommandeInterface;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageCommandeInterfaceTwo;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageCommandeInterfaceThree;
    @Column(nullable = false)
    private double prixArticle;
    @Column(nullable = false)
    private int qteArticle;

    public Article(String description, String imageCommandeView, String imageCommandeInterface, String imageCommandeInterfaceTwo, String imageCommandeInterfaceThree, double prixArticle, int qteArticle , Designation designation,List<Boutique> boutiqueList ,List<LignCommandeArticle> lignCommandeArticleList) {
        this.description = description;
        this.imageCommandeView = imageCommandeView;
        this.imageCommandeInterface = imageCommandeInterface;
        this.imageCommandeInterfaceTwo = imageCommandeInterfaceTwo;
        this.imageCommandeInterfaceThree = imageCommandeInterfaceThree;
        this.prixArticle = prixArticle;
        this.qteArticle = qteArticle;
    }




    @ManyToMany
    @Basic(fetch = FetchType.LAZY)
    @JoinTable(name = "boutiqueArticle" , joinColumns = @JoinColumn(name = "codeArticle") , inverseJoinColumns = @JoinColumn(name = "codeBoutique"))
    private List<Boutique> boutiqueList = new ArrayList<Boutique>();

    @OneToMany(mappedBy = "article")
    @Basic(fetch = FetchType.LAZY)
    private List<LignCommandeArticle> lignCommandeArticle = new ArrayList<LignCommandeArticle>();

    public void addLignCommandeArticle(LignCommandeArticle l){
        l.setArticle(this);
        lignCommandeArticle.add(l);
    }
    public void AddBoutique(Boutique b){
        b.getArticleList().add(this);
        boutiqueList.add(b);
    }
}
