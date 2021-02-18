package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class RoleVO implements Serializable {

    private long codeRole;
    private String nomRole;
    private List<Personne> personneList = new ArrayList<>();

    public RoleVO(long codeRole,String nomRole) {
        this.codeRole = codeRole;
        this.nomRole = nomRole;
    }


}
