package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Admin extends  Personne {
    public Admin(String nomPersonne, String presnomPersonne, String cinPersonne, String emailPersonne, String pwdPersonne, String photoProfile ,Role listRole) {
        super(nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photoProfile,listRole);
    }
}
