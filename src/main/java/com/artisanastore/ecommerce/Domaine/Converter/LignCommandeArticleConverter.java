package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.LigneCommandeArticleVO;
import com.artisanastore.ecommerce.Models.Article;
import com.artisanastore.ecommerce.Models.LignCommandeArticle;

import java.util.ArrayList;
import java.util.List;

public class LignCommandeArticleConverter {
    public static LigneCommandeArticleVO ligneCommandeArticleBoToVo(LignCommandeArticle bo){
        LigneCommandeArticleVO vo = new LigneCommandeArticleVO(bo.getCodeLignCommandeArticle(),bo.getQtecodeLignCommandeArticle(),CommandeConverter.commandeBoToVo(bo.getCommandeLigne()
                ),ArticleConverter.articleBotoVo(bo.getArticle()));
        return vo;
    }
    public static LignCommandeArticle ligneCommandeArticleVoToBo(LigneCommandeArticleVO vo){
        LignCommandeArticle bo = new LignCommandeArticle(vo.getQtecodeLignCommandeArticle() , CommandeConverter.commandeVoToBo(vo.getCommandeLigne()) ,
                ArticleConverter.articleVotoBo(vo.getArticle()));
        return bo;
    }
    public static List<LigneCommandeArticleVO> listLigneCommandeArticleBoToVo(List<LignCommandeArticle> bo){
        List<LigneCommandeArticleVO> listVo = new ArrayList<LigneCommandeArticleVO>();
          for(LignCommandeArticle lignCommandeArticle:bo){
              LigneCommandeArticleVO vo = LignCommandeArticleConverter.ligneCommandeArticleBoToVo(lignCommandeArticle);
              listVo.add(vo);
          }
        return listVo;
    }

    public static List<LignCommandeArticle> listLigneCommandeArticleVoToBo(List<LigneCommandeArticleVO> bo){
        List<LignCommandeArticle> listBo = new ArrayList<LignCommandeArticle>();
        for(LigneCommandeArticleVO lignCommandeArticle:bo){
            LignCommandeArticle lignCommandeArticle1 = LignCommandeArticleConverter.ligneCommandeArticleVoToBo(lignCommandeArticle);
            listBo.add(lignCommandeArticle1);
        }
        return listBo;
    }

}
