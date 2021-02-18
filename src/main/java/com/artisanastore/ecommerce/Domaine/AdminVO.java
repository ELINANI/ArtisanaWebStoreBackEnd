package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class AdminVO  extends  PersonneVO{
    public AdminVO(long codePersonne,String nomPersonne,
                   String presnomPersonne, String cinPersonne, String emailPersonne,
                   String pwdPersonne, String photoProfile,
                   RoleVO roleVOList) {
        super(codePersonne,nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photoProfile,roleVOList);
    }

}
