package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private long codeRole;
    private String nomRole;

    public Role(String nomRole) {
        this.nomRole = nomRole;
    }
    @OneToMany(mappedBy = "role")
    @Basic(fetch = FetchType.LAZY)
    private List<Personne> personneList = new ArrayList<>();


    public void addPersonne(Personne r){
         r.setRole(this);
         personneList.add(r);
    }

}
