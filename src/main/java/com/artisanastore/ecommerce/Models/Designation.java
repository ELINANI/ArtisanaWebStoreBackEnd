package com.artisanastore.ecommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Designation  implements Serializable {

    @Id
    @GeneratedValue
    private long codeDesignation ;
    @Column(unique = true)
    private String descriptionDesignation;


    public Designation(String descriptionDesignation , List<Article> articleList) {
        this.descriptionDesignation = descriptionDesignation;

    }

    public void addArticle(Article art){

    }
}
