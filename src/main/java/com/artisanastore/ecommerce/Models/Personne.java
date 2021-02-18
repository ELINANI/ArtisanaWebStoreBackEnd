package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {

    @Id
    @GeneratedValue
    private long codePersonne;
    @Column(nullable = false)
    private String nomPersonne;
    @Column(nullable = false)
    private String presnomPersonne;
    @Column(unique = true)
    private  String cinPersonne ;
    @Column(unique = true ,nullable = false)
    private  String emailPersonne ;
    @Column(nullable = false)
    private String pwdPersonne;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photoProfile;
    public Personne(String nomPersonne, String presnomPersonne, String cinPersonne, String emailPersonne, String pwdPersonne,String photo,Role role) {
        this.nomPersonne = nomPersonne;
        this.presnomPersonne = presnomPersonne;
        this.cinPersonne = cinPersonne;
        this.emailPersonne = emailPersonne;
        this.pwdPersonne = pwdPersonne;
        this.photoProfile = photo;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role ;

}
