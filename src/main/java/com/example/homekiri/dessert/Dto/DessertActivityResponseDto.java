package com.example.homekiri.dessert.Dto;

import com.example.homekiri.dessert.model.DessertActivity;
import com.example.homekiri.dessert.model.DessertImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DessertActivityResponseDto {
    private Long idx;
    private String Category;
    private String temperature;
    private String dessertName;
    private String description;
    private List<String> imgUrl;

    public DessertActivityResponseDto(DessertActivity entity1){
        this.idx = entity1.getIdx();
        if(entity1.getDrink() != null){
            this.Category = entity1.getDrink().getDrinkName();
            this.temperature = entity1.getDrink().getTemperature();
        }else{
            this.Category = entity1.getNonDrink().getNonDrinkName();
            this.temperature = entity1.getNonDrink().getTemperature();
        }
        this.dessertName = entity1.getDessertName();
        this.description = entity1.getDescription();
        this.imgUrl = new ArrayList<>();
        for(DessertImage url: entity1.getDessertImageList())
            imgUrl.add(url.getImgUrl());
    }

   
}
