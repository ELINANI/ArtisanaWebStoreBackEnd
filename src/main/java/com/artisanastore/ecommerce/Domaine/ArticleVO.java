package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Boutique;
import com.artisanastore.ecommerce.Models.Designation;
import com.artisanastore.ecommerce.Models.LignCommandeArticle;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class ArticleVO implements Serializable {

    private long codeArticle;
    private String description;
    private String imageCommandeView;
    private String imageCommandeInterface;
    private String imageCommandeInterfaceTwo;
    private String imageCommandeInterfaceThree;
    private double prixArticle;
    private int qteArticle;
    private DesignationVO designation = new DesignationVO();
    private List<BoutiqueVO> boutiqueList = new ArrayList<BoutiqueVO>();
    private List<LigneCommandeArticleVO> lignCommandeArticle = new ArrayList<LigneCommandeArticleVO>();


    public ArticleVO(long codeArticle,String description, String imageCommandeView,
                     String imageCommandeInterface, String imageCommandeInterfaceTwo,
                     String imageCommandeInterfaceThree, double prixArticle, int qteArticle ,
                      List<BoutiqueVO> boutiqueVOList ,List<LigneCommandeArticleVO> ligneCommandeArticleVOList) {
        this.codeArticle = codeArticle;
        this.description = description;
        this.imageCommandeView = imageCommandeView;
        this.imageCommandeInterface = imageCommandeInterface;
        this.imageCommandeInterfaceTwo = imageCommandeInterfaceTwo;
        this.imageCommandeInterfaceThree = imageCommandeInterfaceThree;
        this.prixArticle = prixArticle;
        this.qteArticle = qteArticle;

        this.boutiqueList = boutiqueVOList;
        this.lignCommandeArticle =ligneCommandeArticleVOList;

    }


}
