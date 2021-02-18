package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Article;
import com.artisanastore.ecommerce.Models.Artisan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class BoutiqueVO  implements Serializable {
    private long codeBoutique;
    private String dateCreationBoutique;
    private ArtisanVO artisan = new ArtisanVO();
    private List<ArticleVO> articleList = new ArrayList<ArticleVO>();


    public BoutiqueVO(long codeBoutique,String dateCreationBoutique , ArtisanVO artisan , List<ArticleVO> articleList)  {
        this.codeBoutique = codeBoutique;
        this.dateCreationBoutique = dateCreationBoutique;
        this.artisan = artisan;
        this.articleList =articleList;

    }
}
