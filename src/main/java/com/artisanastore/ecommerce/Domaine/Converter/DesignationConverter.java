package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.DesignationVO;
import com.artisanastore.ecommerce.Models.Designation;

import java.util.ArrayList;
import java.util.List;

public class DesignationConverter {

    public static DesignationVO designationBoToVo(Designation bo){
        DesignationVO vo = new DesignationVO(bo.getCodeDesignation(),bo.getDescriptionDesignation());
        return vo;
    }

    public static Designation designationVoToBo(DesignationVO vo){
        Designation bo = new Designation(vo.getDescriptionDesignation() , ArticleConverter.listArticleVoToBo(vo.getArticleList()));
        return bo;
    }
    public static List<DesignationVO> listDesignationBoToVo(List<Designation> bo){
        List<DesignationVO> listVo= new ArrayList<DesignationVO>();
          for(Designation designation:bo){
              DesignationVO vo = DesignationConverter.designationBoToVo(designation);
              listVo.add(vo);
          }
        return listVo;
    }
}
