package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.ArtisanVO;
import com.artisanastore.ecommerce.Models.Artisan;

import java.util.ArrayList;
import java.util.List;

public class ArtisanConverter {

    public static ArtisanVO artivaBoToVo(Artisan bo){
        ArtisanVO vo = new ArtisanVO(bo.getCodePersonne(), bo.getNomPersonne(),bo.getPresnomPersonne(),bo.getCinPersonne(),bo.getEmailPersonne(),bo.getPwdPersonne(),bo.getPhotoProfile(),RoleConverter.roleBoToVo(bo.getRole()) ,BoutiqueConverter.listBoutiqueBoToVo(bo.getBoutiqueList()),ValidationConverter.listValidationBoToVo(bo.getValidationList()));
        return vo;
    }
    public static Artisan artivaVoToBo(ArtisanVO vo){
        Artisan bo = new Artisan(vo.getNomPersonne(),vo.getPresnomPersonne(),vo.getCinPersonne(),vo.getEmailPersonne(),vo.getPwdPersonne(),vo.getPhotoProfile() , RoleConverter.roleVoToBo(vo.getRole()),BoutiqueConverter.listBoutiqueVoToBo(vo.getBoutiqueList()),ValidationConverter.listValidationVoToBo(vo.getValidationList()));
        return bo;
    }

    public static List<ArtisanVO> listArtisanBoToVo(List<Artisan> bo){
        List<ArtisanVO> voList = new ArrayList<ArtisanVO>();
           for(Artisan r : bo) {
               ArtisanVO v = ArtisanConverter.artivaBoToVo(r);
               voList.add(v);
           }
        return voList;
    }
}
