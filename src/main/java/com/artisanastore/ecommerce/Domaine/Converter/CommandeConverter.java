package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.CommandeVO;
import com.artisanastore.ecommerce.Models.Commande;

import java.util.ArrayList;
import java.util.List;

public class CommandeConverter {
    public static CommandeVO commandeBoToVo(Commande bo){
        CommandeVO vo = new CommandeVO(bo.getCodeCommande(),bo.getDateCommande(),ClientConverter.clientBoToVo(bo.getClient()),ValidationConverter.validationBoToVo(bo.getValidation()),LignCommandeArticleConverter.listLigneCommandeArticleBoToVo(bo.getLignCommandeArticle()));
        return vo;
    }

    public static Commande commandeVoToBo(CommandeVO vo){
        Commande bo = new Commande(vo.getDateCommande(),ClientConverter.clientVoToBo(vo.getClient()),ValidationConverter.validationVoToBo(vo.getValidation()),LignCommandeArticleConverter.listLigneCommandeArticleVoToBo(vo.getLignCommandeArticle()));
        return bo;
    }
    public static List<CommandeVO> listCommandeBoToVo(List<Commande> bo){
        List<CommandeVO> listVo = new ArrayList<CommandeVO>();
          for(Commande cmd : bo) {
              CommandeVO vo = CommandeConverter.commandeBoToVo(cmd);
              listVo.add(vo);
          }
        return  listVo;
    }

    public static List<Commande> listCommandeVoToBo(List<CommandeVO> vo){
        List<Commande> listVo = new ArrayList<Commande>();
        for(CommandeVO cmd : vo) {
            Commande v  = CommandeConverter.commandeVoToBo(cmd);
            listVo.add(v);
        }
        return  listVo;
    }
}
