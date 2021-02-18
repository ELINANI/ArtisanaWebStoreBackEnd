package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Models.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleConverter {
   public  static RoleVO roleBoToVo(Role bo){
        RoleVO v = new RoleVO(bo.getCodeRole(),bo.getNomRole());
        return v ;
   }
    public  static Role roleVoToBo(RoleVO bo){
        Role v = new Role(bo.getNomRole());
        return v ;
    }
    public  static List<RoleVO> listRoleBoToVo(List<Role> bo) {
        List<RoleVO> list = new ArrayList<RoleVO>();
                for (Role r : bo){
                    RoleVO v = RoleConverter.roleBoToVo(r);
                    list.add(v);
                }
                return  list ;
    }
    public  static List<Role> listRoleVoToBo(List<RoleVO> vo) {
        List<Role> list = new ArrayList<Role>();
        for (RoleVO r : vo){
            Role v = RoleConverter.roleVoToBo(r);
            list.add(v);
        }
        return  list ;
    }
}
