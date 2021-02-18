package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.PersonneVO;
import com.artisanastore.ecommerce.Models.Personne;
import com.artisanastore.ecommerce.Models.Role;
import jdk.internal.dynalink.beans.StaticClass;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PersonneConverter {
    public static PersonneVO personneBoToVo(Personne bo){
        PersonneVO vo = new PersonneVO(bo.getCodePersonne(),bo.getNomPersonne(), bo.getPresnomPersonne(), bo.getEmailPersonne(), bo.getEmailPersonne(),bo.getPwdPersonne(),bo.getPhotoProfile(),RoleConverter.roleBoToVo(bo.getRole()));
        return  vo;
    }

    public static Personne personneVoToBo(PersonneVO vo){
        Personne bo = new Personne(vo.getNomPersonne(), vo.getPresnomPersonne(), vo.getEmailPersonne(), vo.getEmailPersonne(),vo.getPwdPersonne(),vo.getPhotoProfile(),RoleConverter.roleVoToBo(vo.getRole()));
        return  bo;
    }
    public  static List<PersonneVO> listPERsonnBoToVo(List<Personne> bo) {
        List<PersonneVO> listVo = new ArrayList<PersonneVO>();
        for(Personne personne :bo){
            PersonneVO vo = PersonneConverter.personneBoToVo(personne);
            listVo.add(vo);
        }
        return  listVo;
    }

    public  static List<Personne> listPersonnVoToBo(List<PersonneVO> vo) {
        List<Personne> listBo = new ArrayList<Personne>();
        for(PersonneVO personneVo :vo){
            Personne personne = PersonneConverter.personneVoToBo(personneVo);
            listBo.add(personne);
        }
        return  listBo;
    }
}
