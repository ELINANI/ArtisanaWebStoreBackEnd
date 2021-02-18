package com.artisanastore.ecommerce.Domaine.Converter;

import com.artisanastore.ecommerce.Domaine.ClientVO;
import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Models.Client;
import com.artisanastore.ecommerce.Models.Commande;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter {

    public static ClientVO clientBoToVo(Client bo) {
        ClientVO vo = new ClientVO(bo.getCodePersonne(),bo.getNomPersonne(),
                bo.getPresnomPersonne(),bo.getCinPersonne(),bo.getEmailPersonne(),
                bo.getPwdPersonne(),bo.getPhotoProfile(),RoleConverter.roleBoToVo(bo.getRole()),
                CommandeConverter.listCommandeBoToVo(bo.getCommandeList()));
        return vo ;
    }
    public static Client clientVoToBo(ClientVO vo) {
        Client bo = new Client(vo.getNomPersonne(),vo.getPresnomPersonne(),vo.getCinPersonne(),vo.getEmailPersonne(),vo.getPwdPersonne(),vo.getPhotoProfile(),RoleConverter.roleVoToBo(vo.getRole()),CommandeConverter.listCommandeVoToBo(vo.getCommandeList()));
        Commande c = new Commande();
        bo.addCommande(c);
        bo.setRole(RoleConverter.roleVoToBo(vo.getRole()));
        return bo ;
    }
    public static  List<ClientVO> listClientBoToVo(List<Client> bo) {
        List<ClientVO> listVo = new ArrayList<ClientVO>();
        for(Client c : bo) {
             ClientVO vo = ClientConverter.clientBoToVo(c);
             listVo.add(vo);
        }
        return  listVo ;
    }
}
