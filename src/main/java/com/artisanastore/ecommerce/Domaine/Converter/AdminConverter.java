package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.AdminVO;
import com.artisanastore.ecommerce.Models.Admin;
import com.artisanastore.ecommerce.Models.Role;

import java.util.ArrayList;
import java.util.List;

public class AdminConverter {
     public static AdminVO adminBoToVo(Admin bo){
         AdminVO vo = new AdminVO(bo.getCodePersonne(),bo.getNomPersonne(),bo.getPresnomPersonne(),bo.getCinPersonne(),bo.getEmailPersonne(),bo.getPwdPersonne(),bo.getPhotoProfile(),RoleConverter.roleBoToVo(bo.getRole()));
         return vo;
     }
     public static  Admin adminVoToBo(AdminVO vo){
         Admin bo = new Admin(vo.getNomPersonne(),vo.getPresnomPersonne(),vo.getCinPersonne(),vo.getEmailPersonne(),vo.getPwdPersonne(),vo.getPhotoProfile(),RoleConverter.roleVoToBo(vo.getRole()));
         return bo;
     }
     public  static  List<AdminVO>  listAdminBoToVo(List<Admin> bo){
         List<AdminVO> listVO = new ArrayList<AdminVO>();
          for(Admin a : bo){
            AdminVO vo = AdminConverter.adminBoToVo(a);
            listVO.add(vo);
          }
         return  listVO ;
     }


}
