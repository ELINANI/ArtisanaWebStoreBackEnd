package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.ValidationVO;
import com.artisanastore.ecommerce.Models.Commande;
import com.artisanastore.ecommerce.Models.Validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationConverter {

    public static ValidationVO validationBoToVo(Validation bo){
        ValidationVO vo = new ValidationVO(bo.getCodeValidation(),bo.getDateAjoutCommande(),bo.getDateAjoutValidation(),ArtisanConverter.artivaBoToVo(bo.getArtisan()),
                CommandeConverter.commandeBoToVo(bo.getCommande()));
        return vo ;
    }

    public static Validation validationVoToBo(ValidationVO vo){
        Validation bo = new Validation(vo.getDateAjoutCommande(),vo.getDateAjoutValidation(),ArtisanConverter.artivaVoToBo(vo.getArtisan()) ,CommandeConverter.commandeVoToBo(vo.getCommande()));
        return bo ;
    }

    public static List<ValidationVO> listValidationBoToVo(List<Validation> bo){
        List<ValidationVO> listVo = new ArrayList<ValidationVO>();
        for(Validation validation :bo){
            ValidationVO vo = ValidationConverter.validationBoToVo(validation);
            listVo.add(vo);
        }
        return listVo;
    }

    public static List<Validation> listValidationVoToBo(List<ValidationVO> vo){
        List<Validation> listVo = new ArrayList<Validation>();
        for(ValidationVO validation :vo){
            Validation v = ValidationConverter.validationVoToBo(validation);
            listVo.add(v);
        }
        return listVo;
    }
}
