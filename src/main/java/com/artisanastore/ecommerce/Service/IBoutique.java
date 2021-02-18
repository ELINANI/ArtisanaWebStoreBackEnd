package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.BoutiqueVO;

import java.util.List;

public interface IBoutique {
    List<BoutiqueVO> getAllBoutique();
    void addBoutique(BoutiqueVO boutiqueVO);
    void updateBoutique(long codeBoutique,BoutiqueVO boutiqueVO);
    void deleteBoutique(long codeBoutique);
    BoutiqueVO findBycodeBoutique(long codeBoutique);
}
