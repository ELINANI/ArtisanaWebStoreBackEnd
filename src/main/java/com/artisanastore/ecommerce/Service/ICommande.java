package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.CommandeVO;

import java.util.List;

public interface ICommande {
    List<CommandeVO> getAllCommande();
    void addCommande(CommandeVO commandeVO);
    void updateCommande(long codeCommande,CommandeVO commandeVO);
    void deleteCommande(long codeCommande);
    CommandeVO findByCodeCommande(long codeCommande);
}
