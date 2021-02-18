package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Client extends  Personne{

  @OneToMany(mappedBy = "client")
  @Basic(fetch = FetchType.LAZY)
  private List<Commande> commandeList = new ArrayList<Commande>();
  public Client(String nomPersonne, String presnomPersonne, String cinPersonne, String emailPersonne, String pwdPersonne,String photo,Role roleList ,List<Commande> commandeList) {
    super(nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photo,roleList);

  }
  public void addCommande(Commande cmd){
    cmd.setClient(this);
    commandeList.add(cmd);
  }
}
