package com.artisanastore.ecommerce.Service.Implementations;

import com.artisanastore.ecommerce.Dao.ArticleRepo;
import com.artisanastore.ecommerce.Dao.ArtisanRepo;
import com.artisanastore.ecommerce.Domaine.ArticleVO;
import com.artisanastore.ecommerce.Domaine.ArtisanVO;
import com.artisanastore.ecommerce.Domaine.Converter.ArticleConverter;
import com.artisanastore.ecommerce.Models.Article;
import com.artisanastore.ecommerce.Service.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class ArticleImpl implements IArticle {
    @Autowired
    private ArticleRepo articleRepo;
    @Override
    public List<ArticleVO> getAllArticle() {
        List<ArticleVO> list = ArticleConverter.listArticleBoToVo(articleRepo.findAll());
        return list;
    }
    @Override
    public void addArticle(MultipartFile imageCommandeView, MultipartFile imageCommandeInterface, MultipartFile imageCommandeInterfaceTwo, MultipartFile imageCommandeInterfaceThree, ArticleVO articleVO) {
        try {
            articleVO.setImageCommandeView(Base64.getEncoder().encodeToString(imageCommandeView.getBytes()));
            articleVO.setImageCommandeInterface(Base64.getEncoder().encodeToString(imageCommandeInterface.getBytes()));
            articleVO.setImageCommandeInterfaceTwo(Base64.getEncoder().encodeToString(imageCommandeInterfaceTwo.getBytes()));
            articleVO.setImageCommandeInterfaceThree(Base64.getEncoder().encodeToString(imageCommandeInterfaceThree.getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        articleRepo.save(ArticleConverter.articleVotoBo(articleVO));
    }


    @Override
    public void updateArticle(long codeArticle,MultipartFile imageCommandeView,MultipartFile imageCommandeInterface,MultipartFile imageCommandeInterfaceTwo,MultipartFile imageCommandeInterfaceThree, ArticleVO articleVO) {
      ArticleVO articleUpdated = ArticleConverter.articleBotoVo(articleRepo.findByCodeArticle(codeArticle));
      if(imageCommandeView != null) {
          try {
              articleUpdated.setImageCommandeView(Base64.getEncoder().encodeToString(imageCommandeView.getBytes()));
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      if(imageCommandeInterface != null) {
          try {
              articleUpdated.setImageCommandeInterface(Base64.getEncoder().encodeToString(imageCommandeInterface.getBytes()));
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      if(imageCommandeInterfaceTwo!=null){
          try {
              articleUpdated.setImageCommandeInterfaceTwo(Base64.getEncoder().encodeToString(imageCommandeInterfaceTwo.getBytes()));
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
        if(imageCommandeInterfaceThree!=null){
            try {
                articleUpdated.setImageCommandeInterfaceThree(Base64.getEncoder().encodeToString(imageCommandeInterfaceThree.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        articleUpdated.setPrixArticle(articleVO.getPrixArticle());
        articleUpdated.setQteArticle(articleVO.getQteArticle());
        articleUpdated.setDescription(articleUpdated.getDescription());
        articleUpdated.setBoutiqueList(articleVO.getBoutiqueList());
        articleUpdated.setDesignation(articleVO.getDesignation());
      articleRepo.save(ArticleConverter.articleVotoBo(articleUpdated));
    }

    @Override
    public void deleteArticle(long codeArticle) {
        articleRepo.deleteById(codeArticle);
    }

    @Override
    public ArticleVO findByCodeArticle(long codeArticle) {
        ArticleVO articleVO = ArticleConverter.articleBotoVo(articleRepo.findByCodeArticle(codeArticle));
        return articleVO;
    }
}
