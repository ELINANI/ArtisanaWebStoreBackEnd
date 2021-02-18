package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.ValidationRepo;
import com.artisanastore.ecommerce.Domaine.Converter.ValidationConverter;
import com.artisanastore.ecommerce.Domaine.ValidationVO;
import com.artisanastore.ecommerce.Service.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ValidationImpl implements IValidation {
    @Autowired
    private ValidationRepo validationRepo;
    @Override
    public List<ValidationVO> getAllValidation() {
        List<ValidationVO> list = ValidationConverter.listValidationBoToVo(validationRepo.findAll());
        return  list;
    }

    @Override
    public void addValidation(ValidationVO validationVO) {
      validationRepo.save(ValidationConverter.validationVoToBo(validationVO));
    }

    @Override
    public void updateValidation(long codeValidation, ValidationVO validationVO) {
        ValidationVO validationUpdated = ValidationConverter.validationBoToVo(validationRepo.findByCodeValidation(codeValidation));
        validationUpdated.setDateAjoutValidation(validationVO.getDateAjoutValidation());
        validationUpdated.setDateAjoutCommande(validationVO.getDateAjoutCommande());
        validationUpdated.setCommande(validationVO.getCommande());
        validationRepo.save(ValidationConverter.validationVoToBo(validationVO));
    }

    @Override
    public void deleteVaidation(long codeValidation) {
      validationRepo.deleteById(codeValidation);
    }

    @Override
    public ValidationVO findByCodeValidation(long codeValidation) {
        ValidationVO validationVO = ValidationConverter.validationBoToVo(validationRepo.findByCodeValidation(codeValidation));
        return validationVO;
    }
}
