package com.artisanastore.ecommerce.Domaine;

import com.artisanastore.ecommerce.Models.Commande;
import com.artisanastore.ecommerce.Models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class  ClientVO extends PersonneVO{

    private List<CommandeVO> commandeList = new ArrayList<CommandeVO>();
    public ClientVO(long codePersonne,String nomPersonne, String presnomPersonne, String cinPersonne,
                    String emailPersonne,
                    String pwdPersonne,String photoProfile , RoleVO list , List<CommandeVO> commandeList) {
        super(codePersonne,nomPersonne, presnomPersonne, cinPersonne, emailPersonne, pwdPersonne,photoProfile ,list);
       this.commandeList = commandeList;
    }
}
