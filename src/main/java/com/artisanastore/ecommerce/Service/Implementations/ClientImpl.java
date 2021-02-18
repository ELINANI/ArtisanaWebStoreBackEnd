package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.ClientRepo;
import com.artisanastore.ecommerce.Dao.RoleRepo;
import com.artisanastore.ecommerce.Domaine.ClientVO;
import com.artisanastore.ecommerce.Domaine.CommandeVO;
import com.artisanastore.ecommerce.Domaine.Converter.ArtisanConverter;
import com.artisanastore.ecommerce.Domaine.Converter.ClientConverter;
import com.artisanastore.ecommerce.Domaine.Converter.RoleConverter;
import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Models.Client;
import com.artisanastore.ecommerce.Models.Role;
import com.artisanastore.ecommerce.Service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Transactional
@Service
public class ClientImpl implements IClient {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public List<ClientVO> getAllClient() {
        List<ClientVO> list = ClientConverter.listClientBoToVo(clientRepo.findAll());
        return list;
    }
    @Override
    public void addClient(MultipartFile photo, ClientVO clientVO) {
        try {
            clientVO.setPhotoProfile(Base64.getEncoder().encodeToString(photo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Role>  roleList= roleRepo.findAll();
        for(Role r : roleList){
            if(r.getNomRole() != null){
                if(r.getNomRole().equals("Client")){
                    clientVO.setPwdPersonne(bCryptPasswordEncoder.encode(clientVO.getPwdPersonne()));
                    //clientVO.getRole().setCodeRole(r.getCodeRole());
                    //Role rr = roleRepo.save(RoleConverter.roleVoToBo(clientVO.getRole()));
                    Client c = ClientConverter.clientVoToBo(clientVO);
                    c.setRole(r);
                    clientRepo.save(c);
                }
            }
        }


    }

    @Override
    public void updateClient(long codeClient,MultipartFile photo, ClientVO clientVO) {
        if(codeClient != 0){
           ClientVO clientUpdated = ClientConverter.clientBoToVo(clientRepo.findByCodePersonne(codeClient));
            if(photo != null){
                try {
                    clientVO.setPhotoProfile(Base64.getEncoder().encodeToString(photo.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            clientUpdated.setNomPersonne(clientVO.getNomPersonne());
            clientUpdated.setPresnomPersonne(clientVO.getPresnomPersonne());
            clientUpdated.setEmailPersonne(clientVO.getEmailPersonne());
            clientUpdated.setPwdPersonne(bCryptPasswordEncoder.encode(clientVO.getPwdPersonne()));
            clientUpdated.setRole(clientVO.getRole());
            clientRepo.save(ClientConverter.clientVoToBo(clientUpdated));
        }
    }
    @Override
    public void deleteClient(long codeClient) {
        if(codeClient != 0)
            clientRepo.deleteById(codeClient);
    }
    @Override
    public ClientVO findByCodeClient(long codeClient) {
        ClientVO clientVO = ClientConverter.clientBoToVo(clientRepo.findByCodePersonne(codeClient));
        return clientVO;
    }

    @Override
    public ClientVO findByEmail(String email) {
        ClientVO vo = ClientConverter.clientBoToVo(clientRepo.findByEmailPersonne(email));
        return vo;
    }
}
