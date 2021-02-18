package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.DesignationVO;

import java.util.List;

public interface IDesignation {
    List<DesignationVO> getAllDesignation();
    void addDesignation(DesignationVO designationVO);
    void updateDesignation(long codeDesignation,DesignationVO designationVO);
    void deleteDesignation(long codeDesignation);
    DesignationVO findByCodeDesignation(long codeDesignation);
}
