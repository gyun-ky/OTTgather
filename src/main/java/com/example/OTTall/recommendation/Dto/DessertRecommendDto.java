package com.example.OTTall.recommendation.Dto;

import com.example.OTTall.dessert.model.DessertActivity;
import com.example.OTTall.dessert.model.DessertImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DessertRecommendDto {
    private Long idx;
    private String dessertName;
    private String Category;
    private List<String> imgUrl;

    public DessertRecommendDto(DessertActivity entity1){
        this.idx = entity1.getIdx();
        this.dessertName = entity1.getDessertName();

        if(entity1.getDrink() != null)
            this.Category = entity1.getDrink().getDrinkName();
        else
            this.Category = entity1.getNonDrink().getNonDrinkName();
        this.imgUrl = new ArrayList<>();
        for(DessertImage url: entity1.getDessertImageList())
            imgUrl.add(url.getImgUrl());
    }
}
