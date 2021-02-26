package com.artisanastore.ecommerce.Controller;

import com.artisanastore.ecommerce.Domaine.ArticleVO;
import com.artisanastore.ecommerce.Service.Implementations.ArticleImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleImpl article ;


    @GetMapping("/article")
    private List<ArticleVO> listArticleVO(){
        List<ArticleVO>  list= article.getAllArticle();
        return  list;
    }
    @PostMapping("/article")
    public ResponseEntity<String> addArticle(@RequestParam("imageCommandeView") MultipartFile imageCommandeView,@RequestParam("imageCommandeInterface") MultipartFile imageCommandeInterface,@RequestParam("imageCommandeInterfaceTwo") MultipartFile imageCommandeInterfaceTwo,@RequestParam("imageCommandeInterfaceThree") MultipartFile imageCommandeInterfaceThree,@RequestParam("ArticleVO") String articleVO){
        Gson gson = new Gson();
        ArticleVO vv = gson.fromJson(articleVO ,ArticleVO.class);
         article.addArticle(imageCommandeView,imageCommandeInterface,imageCommandeInterfaceTwo,imageCommandeInterfaceThree,vv);
        return  new ResponseEntity<String>("Article Added" , HttpStatus.CREATED);
    }
}
