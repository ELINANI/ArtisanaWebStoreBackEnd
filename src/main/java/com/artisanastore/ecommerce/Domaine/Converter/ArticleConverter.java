package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.ArticleVO;
import com.artisanastore.ecommerce.Models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleConverter {

    public static ArticleVO articleBotoVo(Article bo){
        ArticleVO vo = new ArticleVO(bo.getCodeArticle(),bo.getDescription(),bo.getImageCommandeView(),bo.getImageCommandeInterface(),
                bo.getImageCommandeInterfaceTwo(),
                bo.getImageCommandeInterfaceThree(),bo.getPrixArticle(),
                bo.getQteArticle(),DesignationConverter.designationBoToVo(bo.getDesignation()),BoutiqueConverter.listBoutiqueBoToVo(bo.getBoutiqueList()) ,LignCommandeArticleConverter.listLigneCommandeArticleBoToVo(bo.getLignCommandeArticle()));
        return  vo ;
    }

    public static Article articleVotoBo(ArticleVO vo){
        Article bo = new Article(vo.getDescription(),vo.getImageCommandeView(),vo.getImageCommandeInterface()
                ,vo.getImageCommandeInterfaceTwo(),vo.getImageCommandeInterfaceThree(),
                vo.getPrixArticle(),vo.getQteArticle() ,DesignationConverter.designationVoToBo(vo.getDesignation()) ,BoutiqueConverter.listBoutiqueVoToBo(vo.getBoutiqueList()), LignCommandeArticleConverter.listLigneCommandeArticleVoToBo(vo.getLignCommandeArticle()));
        return  bo ;
    }
    public static  List<ArticleVO> listArticleBoToVo(List<Article> bo) {
        List<ArticleVO> vo = new ArrayList<ArticleVO>();
         for(Article ar : bo){
             ArticleVO v = ArticleConverter.articleBotoVo(ar);
             vo.add(v);
         }
        return vo;
    }

    public static  List<Article> listArticleVoToBo(List<ArticleVO> vo) {
        List<Article> bo = new ArrayList<Article>();
        for(ArticleVO ar : vo){
            Article v = ArticleConverter.articleVotoBo(ar);
            bo.add(v);
        }
        return bo;
    }
}
