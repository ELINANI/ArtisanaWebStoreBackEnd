package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonneVO implements Serializable {

    private long codePersonne;
    private String nomPersonne;
    private String presnomPersonne;
    private  String cinPersonne ;
    private  String emailPersonne ;
    private String pwdPersonne;
    private RoleVO role = new RoleVO();
    private String photoProfile;
    public PersonneVO(long codePersonne,String nomPersonne, String presnomPersonne, String cinPersonne, String emailPersonne, String pwdPersonne, String photoProfile,RoleVO role) {
        this.codePersonne = codePersonne;
        this.nomPersonne = nomPersonne;
        this.presnomPersonne = presnomPersonne;
        this.cinPersonne = cinPersonne;
        this.emailPersonne = emailPersonne;
        this.pwdPersonne = pwdPersonne;
        this.photoProfile= photoProfile;
        this.role = role;
    }




}
