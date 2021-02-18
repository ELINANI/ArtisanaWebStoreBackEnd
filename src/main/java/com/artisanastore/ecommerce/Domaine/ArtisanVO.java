package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Boutique;
import com.artisanastore.ecommerce.Models.Role;
import com.artisanastore.ecommerce.Models.Validation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class ArtisanVO extends  PersonneVO{
    private List<BoutiqueVO> boutiqueList = new ArrayList<BoutiqueVO>();
    private List<ValidationVO>  validationList = new ArrayList<ValidationVO>();


    public ArtisanVO(long codePersonne,String nomPersonne, String presnomPersonne,
                     String cinPersonne, String emailPersonne, String pwdPersonne,
                     String photoProfile ,RoleVO roleVOList ,
                     List<BoutiqueVO> boutiqueList , List<ValidationVO> list) {
        super(codePersonne,nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photoProfile,roleVOList);
             this.boutiqueList = boutiqueList;
            this.validationList = list;
    }


}
