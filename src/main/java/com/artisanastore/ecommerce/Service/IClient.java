package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.ClientVO;
import com.artisanastore.ecommerce.Models.Client;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IClient {

    List<ClientVO> getAllClient();
    void addClient(MultipartFile photo,ClientVO clientVO);
    void updateClient(long codeClient,MultipartFile photo,ClientVO clientVO);
    void deleteClient(long codeClient);
    ClientVO findByCodeClient(long codeClient);
    ClientVO findByEmail(String email);
}
