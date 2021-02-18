package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Artisan extends Personne{

    @OneToMany(mappedBy = "artisan")
    @Basic(fetch = FetchType.LAZY)
    private List<Boutique> boutiqueList = new ArrayList<Boutique>();

    @OneToMany(mappedBy = "artisan")
    @Basic(fetch = FetchType.LAZY)
    private List<Validation>  validationList = new ArrayList<Validation>();

    public Artisan(String nomPersonne, String presnomPersonne, String cinPersonne, String emailPersonne, String pwdPersonne,String photoProfile,Role listRole,List<Boutique> boutiqueList ,List<Validation>  validationList) {
        super(nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photoProfile ,listRole);

    }

    public void addBoutique(Boutique b){
        b.setArtisan(this);
        boutiqueList.add(b);
    }
    public void addValidation(Validation v){
        v.setArtisan(this);
        validationList.add(v);
    }

}
