package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Domaine.ValidationVO;

import java.util.List;

public interface IValidation {
    List<ValidationVO> getAllValidation();
    void addValidation(ValidationVO validationVO);
    void updateValidation(long codeValidation,ValidationVO validationVO);
    void deleteVaidation(long codeValidation);

    ValidationVO findByCodeValidation(long codeValidation);
}
