package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Models.Role;

import java.util.List;

public interface IRole {
    List<RoleVO> getAllRole();
    void addRole(RoleVO roleVO);
    void updateRole(long codeRole,RoleVO roleVO);
    void deleteRole(long codeRole);
    RoleVO findByRole(long codeRole);
    RoleVO findByNomRole(String nommRole);
}
