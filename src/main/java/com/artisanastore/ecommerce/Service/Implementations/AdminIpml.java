package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.AdminRepo;
import com.artisanastore.ecommerce.Domaine.AdminVO;
import com.artisanastore.ecommerce.Domaine.Converter.AdminConverter;
import com.artisanastore.ecommerce.Service.IAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
@Transactional
@Service
public class AdminIpml implements IAdmin {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<AdminVO> getAllAdmin() {
        List<AdminVO> list = AdminConverter.listAdminBoToVo(adminRepo.findAll());
        return list;
    }
    @Override
    public void addAdmin(MultipartFile photoProfile, AdminVO adminVO) {
        try {
            adminVO.setPhotoProfile(Base64.getEncoder().encodeToString(photoProfile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminVO.setPwdPersonne(bCryptPasswordEncoder.encode(adminVO.getPwdPersonne()));
        adminRepo.save(AdminConverter.adminVoToBo(adminVO));
    }
    @Override
    public void updateAdmin(long codeAdmin, MultipartFile photoProfile,AdminVO adminVO) {
          AdminVO adminUpdated = AdminConverter.adminBoToVo(adminRepo.findByCodePersonne(codeAdmin));
        try {
            adminUpdated.setPhotoProfile(Base64.getEncoder().encodeToString(photoProfile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
          adminUpdated.setNomPersonne(adminVO.getNomPersonne());
          adminUpdated.setPresnomPersonne(adminVO.getPresnomPersonne());
          adminUpdated.setEmailPersonne(adminVO.getEmailPersonne());
          adminUpdated.setPwdPersonne(bCryptPasswordEncoder.encode(adminVO.getPwdPersonne()));
          adminUpdated.setRole(adminVO.getRole());
         adminRepo.save(AdminConverter.adminVoToBo(adminUpdated));
    }
    @Override
    public void deleteAdmin(long codeAdmin) {
        adminRepo.deleteById(codeAdmin);
    }
    @Override
    public AdminVO findByCodeAdmin(long codeAdmin) {
        AdminVO vo = AdminConverter.adminBoToVo(adminRepo.findByCodePersonne(codeAdmin));
        return vo;
    }
}
