package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.RoleRepo;
import com.artisanastore.ecommerce.Domaine.Converter.RoleConverter;
import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Models.Role;
import com.artisanastore.ecommerce.Service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class RoleImpl implements IRole {
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public List<RoleVO> getAllRole() {
        List<RoleVO> list = RoleConverter.listRoleBoToVo(roleRepo.findAll());
        return list;
    }
    @Override
    public void addRole(RoleVO roleVO) {
        roleRepo.save(RoleConverter.roleVoToBo(roleVO));
    }
    @Override
    public void updateRole(long codeRole, RoleVO roleVO) {
        RoleVO roleUpdated = RoleConverter.roleBoToVo(roleRepo.findByCodeRole(codeRole));
        roleUpdated.setNomRole(roleVO.getNomRole());
        roleRepo.save(RoleConverter.roleVoToBo(roleUpdated));
    }
    @Override
    public void deleteRole(long codeRole) {
   roleRepo.deleteById(codeRole);
    }

    @Override
    public RoleVO findByRole(long codeRole) {
        RoleVO r = RoleConverter.roleBoToVo(roleRepo.findByCodeRole(codeRole));
        return r;
    }

    @Override
    public RoleVO findByNomRole(String nommRole) {
        RoleVO r = RoleConverter.roleBoToVo(roleRepo.findByNomRole(nommRole));
        return r;
    }


}
