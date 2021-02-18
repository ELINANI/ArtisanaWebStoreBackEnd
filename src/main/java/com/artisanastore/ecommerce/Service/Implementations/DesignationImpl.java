package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.DesignationRepo;
import com.artisanastore.ecommerce.Domaine.Converter.DesignationConverter;
import com.artisanastore.ecommerce.Domaine.DesignationVO;
import com.artisanastore.ecommerce.Service.IDesignation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class DesignationImpl implements IDesignation {
    @Autowired
    private DesignationRepo designationRepo;
    @Override
    public List<DesignationVO> getAllDesignation() {
        List<DesignationVO> list = DesignationConverter.listDesignationBoToVo(designationRepo.findAll());
        return list;
    }

    @Override
    public void addDesignation(DesignationVO designationVO) {
        designationRepo.save(DesignationConverter.designationVoToBo(designationVO));
    }

    @Override
    public void updateDesignation(long codeDesignation, DesignationVO designationVO) {
       DesignationVO designationUpdated = DesignationConverter.designationBoToVo(designationRepo.findByCodeDesignation(codeDesignation));
        designationUpdated.setDescriptionDesignation(designationVO.getDescriptionDesignation());
        designationUpdated.setArticleList(designationVO.getArticleList());
        designationRepo.save(DesignationConverter.designationVoToBo(designationUpdated));
    }

    @Override
    public void deleteDesignation(long codeDesignation) {
      designationRepo.deleteById(codeDesignation);
    }

    @Override
    public DesignationVO findByCodeDesignation(long codeDesignation) {
        DesignationVO designationVO = DesignationConverter.designationBoToVo(designationRepo.findByCodeDesignation(codeDesignation));
        return  designationVO;
    }
}
