package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class DesignationVO  implements Serializable {
    private long codeDesignation ;
    private String descriptionDesignation;
    private List<ArticleVO> articleList = new ArrayList<ArticleVO>();

    public DesignationVO(long codeDesignation ,String descriptionDesignation ,List<ArticleVO> articleList) {
        this.codeDesignation = codeDesignation;
        this.descriptionDesignation = descriptionDesignation;
        this.articleList =articleList;

    }
}
