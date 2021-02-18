package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.CommandeRepo;
import com.artisanastore.ecommerce.Domaine.CommandeVO;
import com.artisanastore.ecommerce.Domaine.Converter.CommandeConverter;
import com.artisanastore.ecommerce.Service.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CommandeImp implements ICommande {
    @Autowired
    private CommandeRepo commandeRepo;
    @Override
    public List<CommandeVO> getAllCommande() {
        List<CommandeVO> list = CommandeConverter.listCommandeBoToVo(commandeRepo.findAll());
        return list;
    }

    @Override
    public void addCommande(CommandeVO commandeVO) {
     commandeRepo.save(CommandeConverter.commandeVoToBo(commandeVO));
    }

    @Override
    public void updateCommande(long codeCommande, CommandeVO commandeVO) {

        CommandeVO commandeUpdated = CommandeConverter.commandeBoToVo(commandeRepo.findByCodeCommande(codeCommande));
        commandeUpdated.setDateCommande(commandeVO.getDateCommande());
        commandeUpdated.setClient(commandeVO.getClient());
        commandeUpdated.setLignCommandeArticle(commandeVO.getLignCommandeArticle());
        commandeUpdated.setValidation(commandeVO.getValidation());
        commandeRepo.save(CommandeConverter.commandeVoToBo(commandeUpdated));
    }

    @Override
    public void deleteCommande(long codeCommande) {

        commandeRepo.deleteById(codeCommande);
    }

    @Override
    public CommandeVO findByCodeCommande(long codeCommande) {
        CommandeVO commandeVO = CommandeConverter.commandeBoToVo(commandeRepo.findByCodeCommande(codeCommande));
        return commandeVO;
    }
}
