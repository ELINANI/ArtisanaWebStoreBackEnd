package com.artisanastore.ecommerce.Service.Implementations;
import com.artisanastore.ecommerce.Dao.ArtisanRepo;
import com.artisanastore.ecommerce.Dao.RoleRepo;
import com.artisanastore.ecommerce.Domaine.ArticleVO;
import com.artisanastore.ecommerce.Domaine.ArtisanVO;
import com.artisanastore.ecommerce.Domaine.Converter.ArtisanConverter;
import com.artisanastore.ecommerce.Models.Artisan;
import com.artisanastore.ecommerce.Models.Role;
import com.artisanastore.ecommerce.Service.IArtisan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class ArtisanImp  implements IArtisan {

    @Autowired
    private ArtisanRepo artisanRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public List<ArtisanVO> getAllArtisan() {

        List<ArtisanVO> artisanVOList = ArtisanConverter.listArtisanBoToVo(artisanRepo.findAll());
        return artisanVOList;
    }

    @Transactional
    @Override
    public void addArtisan(MultipartFile photo, ArtisanVO artisanVO) {
        try {
            artisanVO.setPhotoProfile(Base64.getEncoder().encodeToString(photo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Role> list =  roleRepo.findAll();
        for(Role r  : list){
             if(r.getNomRole() != null){
                  if(r.getNomRole().equals("Artisan")){
                      artisanVO.setPwdPersonne(bCryptPasswordEncoder.encode(artisanVO.getPwdPersonne()));
                      Artisan bo = ArtisanConverter.artivaVoToBo(artisanVO);
                      bo.setRole(r);
                      artisanRepo.save(bo);
                  }
             }
        }

    }
    @Transactional
    @Override
    public void updateArtisan(long codeArtisan,MultipartFile photo, ArtisanVO artisanVO) {
         ArtisanVO artisanUpdated = ArtisanConverter.artivaBoToVo(artisanRepo.findByCodePersonne(codeArtisan));
         if(photo != null){
             try {
                 artisanUpdated.setPhotoProfile(Base64.getEncoder().encodeToString(photo.getBytes()));
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        artisanUpdated.setNomPersonne(artisanVO.getNomPersonne());
        artisanUpdated.setPresnomPersonne(artisanVO.getPresnomPersonne());
        artisanUpdated.setEmailPersonne(artisanVO.getEmailPersonne());
        artisanUpdated.setPwdPersonne(bCryptPasswordEncoder.encode(artisanVO.getPwdPersonne()));
        artisanUpdated.setRole(artisanVO.getRole());
         artisanRepo.save(ArtisanConverter.artivaVoToBo(artisanUpdated));
    }
    @Transactional
    @Override
    public void deleteArtisan(long codeArtisan) {
       artisanRepo.deleteById(codeArtisan);
    }

    @Override
    public ArtisanVO findByCodeArtisan(long codeArtisan) {
        ArtisanVO artisanVO = ArtisanConverter.artivaBoToVo(artisanRepo.findByCodePersonne(codeArtisan));
        return artisanVO;
    }

    @Override
    public ArtisanVO findByEmail(String email) {
        ArtisanVO vo = ArtisanConverter.artivaBoToVo(artisanRepo.findByEmailPersonne(email));
        return vo;
    }
}
