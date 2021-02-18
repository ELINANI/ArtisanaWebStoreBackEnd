package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.LignCommandeArticleRepo;
import com.artisanastore.ecommerce.Domaine.Converter.LignCommandeArticleConverter;
import com.artisanastore.ecommerce.Domaine.LigneCommandeArticleVO;
import com.artisanastore.ecommerce.Service.ILignCommandeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class LignCommandeArticleImpl implements ILignCommandeArticle {
    @Autowired
    private LignCommandeArticleRepo lignCommandeArticleRepo;
    @Override
    public List<LigneCommandeArticleVO> getAllLignCommandeArticle() {
        List<LigneCommandeArticleVO> list = LignCommandeArticleConverter.listLigneCommandeArticleBoToVo(lignCommandeArticleRepo.findAll());
        return list;
    }

    @Override
    public void addLignCommandeArticle(LigneCommandeArticleVO ligneCommandeArticleVO) {
          lignCommandeArticleRepo.save(LignCommandeArticleConverter.ligneCommandeArticleVoToBo(ligneCommandeArticleVO));
    }

    @Override
    public void updateLignCommandeArticle(long codeLignCommandeArticle, LigneCommandeArticleVO ligneCommandeArticleVO) {
        LigneCommandeArticleVO ligneCommandeArticleUpdated = LignCommandeArticleConverter.ligneCommandeArticleBoToVo(lignCommandeArticleRepo.findByCodeLignCommandeArticle(codeLignCommandeArticle));
        ligneCommandeArticleUpdated.setQtecodeLignCommandeArticle(ligneCommandeArticleVO.getQtecodeLignCommandeArticle());
        ligneCommandeArticleUpdated.setArticle(ligneCommandeArticleVO.getArticle());
        ligneCommandeArticleUpdated.setCommandeLigne(ligneCommandeArticleVO.getCommandeLigne());
        lignCommandeArticleRepo.save(LignCommandeArticleConverter.ligneCommandeArticleVoToBo(ligneCommandeArticleUpdated));
    }

    @Override
    public void deleteLignCommandeArticle(long codeLignCommandeArticle) {
           lignCommandeArticleRepo.deleteById(codeLignCommandeArticle);
    }

    @Override
    public LigneCommandeArticleVO findByCodeLignCommandeArticle(long codeLigneCommandeArticleVO) {
        LigneCommandeArticleVO ligneCommandeArticleVO = LignCommandeArticleConverter.ligneCommandeArticleBoToVo(lignCommandeArticleRepo.findByCodeLignCommandeArticle(codeLigneCommandeArticleVO));
        return ligneCommandeArticleVO;
    }
}

