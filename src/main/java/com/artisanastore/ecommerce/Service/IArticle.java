package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.ArticleVO;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface IArticle {

    List<ArticleVO> getAllArticle();
    void addArticle(MultipartFile imageCommandeView,MultipartFile imageCommandeInterface,MultipartFile imageCommandeInterfaceTwo,MultipartFile imageCommandeInterfaceThree , ArticleVO articleVO);
    void updateArticle(long codeArticle,MultipartFile imageCommandeView,MultipartFile imageCommandeInterface,MultipartFile imageCommandeInterfaceTwo,MultipartFile imageCommandeInterfaceThree,ArticleVO articleVO);
    void deleteArticle(long codeArticle);
    ArticleVO findByCodeArticle(long codeArticle);
}
