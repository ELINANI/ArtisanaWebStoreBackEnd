package com.artisanastore.ecommerce.Service;

import com.artisanastore.ecommerce.Domaine.ArticleVO;
import com.artisanastore.ecommerce.Domaine.ArtisanVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IArtisan {
    List<ArtisanVO> getAllArtisan();
    void addArtisan(MultipartFile photo, ArtisanVO artisanVO);
    void updateArtisan(long codeArtisan,MultipartFile photo,ArtisanVO artisanVO);
    void deleteArtisan(long codeArtisan);
    ArtisanVO findByCodeArtisan(long codeArtisan);
    ArtisanVO findByEmail(String email);
}
