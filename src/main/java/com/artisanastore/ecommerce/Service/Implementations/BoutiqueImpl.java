package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.BoutiqueRepo;
import com.artisanastore.ecommerce.Domaine.BoutiqueVO;
import com.artisanastore.ecommerce.Domaine.Converter.BoutiqueConverter;
import com.artisanastore.ecommerce.Service.IBoutique;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BoutiqueImpl implements IBoutique {
    @Autowired
    private BoutiqueRepo boutiqueRepo ;
    @Override
    public List<BoutiqueVO> getAllBoutique() {
        List<BoutiqueVO> list = BoutiqueConverter.listBoutiqueBoToVo(boutiqueRepo.findAll());
        return list;
    }

    @Override
    public void addBoutique(BoutiqueVO boutiqueVO) {
     boutiqueRepo.save(BoutiqueConverter.boutiqueVoToBo(boutiqueVO));
    }

    @Override
    public void updateBoutique(long codeBoutique, BoutiqueVO boutiqueVO) {

       BoutiqueVO boutiqueUpdated = BoutiqueConverter.boutiqueBoToVo(boutiqueRepo.findByCodeBoutique(codeBoutique));
       boutiqueUpdated.setDateCreationBoutique(boutiqueVO.getDateCreationBoutique());
       boutiqueUpdated.setArtisan(boutiqueVO.getArtisan());
       boutiqueUpdated.setArticleList(boutiqueVO.getArticleList());
        boutiqueRepo.save(BoutiqueConverter.boutiqueVoToBo(boutiqueUpdated));
    }

    @Override
    public void deleteBoutique(long codeBoutique) {
        boutiqueRepo.deleteById(codeBoutique);

    }

    @Override
    public BoutiqueVO findBycodeBoutique(long codeBoutique) {
        BoutiqueVO boutiqueVO = BoutiqueConverter.boutiqueBoToVo(boutiqueRepo.findByCodeBoutique(codeBoutique));
        return boutiqueVO;
    }
}
