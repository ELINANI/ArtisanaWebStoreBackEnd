package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.BoutiqueVO;
import com.artisanastore.ecommerce.Models.Boutique;

import java.util.ArrayList;
import java.util.List;

public class BoutiqueConverter {
     public static BoutiqueVO boutiqueBoToVo(Boutique bo) {
         BoutiqueVO vo = new BoutiqueVO(bo.getCodeBoutique(),bo.getDateCreationBoutique() ,ArtisanConverter.artivaBoToVo(bo.getArtisan()),
                 ArticleConverter.listArticleBoToVo(bo.getArticleList()));
         return  vo;
     }
    public static Boutique boutiqueVoToBo(BoutiqueVO vo) {
        Boutique bo = new Boutique(vo.getDateCreationBoutique() ,ArtisanConverter.artivaVoToBo(vo.getArtisan()),ArticleConverter.listArticleVoToBo(vo.getArticleList()));
        return  bo;
    }
    public static List<BoutiqueVO> listBoutiqueBoToVo(List<Boutique> bo){
         List<BoutiqueVO> listVo = new ArrayList<BoutiqueVO>();
          for(Boutique b :bo) {
              BoutiqueVO v = BoutiqueConverter.boutiqueBoToVo(b);
              listVo.add(v);
          }
         return listVo ;
    }
    public static List<Boutique> listBoutiqueVoToBo(List<BoutiqueVO> vo){
        List<Boutique> listBo = new ArrayList<Boutique>();
        for(BoutiqueVO b :vo) {
            Boutique v = BoutiqueConverter.boutiqueVoToBo(b);
            listBo.add(v);
        }
        return listBo ;
    }

}
