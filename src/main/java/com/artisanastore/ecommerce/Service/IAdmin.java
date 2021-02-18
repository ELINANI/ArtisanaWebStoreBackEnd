package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.AdminVO;
import com.artisanastore.ecommerce.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAdmin {
     List<AdminVO> getAllAdmin();
     void addAdmin(MultipartFile photoProfile, AdminVO adminVO);
     void updateAdmin(long codeAdmin,MultipartFile photoProfile,AdminVO adminVO);
     void deleteAdmin(long codeAdmin);
     AdminVO findByCodeAdmin(long codeAdmin);
}
