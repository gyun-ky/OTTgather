package com.example.homekiri.recommendation.Dto;

import com.example.homekiri.food.model.FoodActivity;
import lombok.Getter;

@Getter
public class FoodRecommendDto {
    private Long idx;
    private String category;
    private String foodName;
    private String imgUrl;


    public FoodRecommendDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.category = CountryIdxToString(entity.getCountry().getIdx());
        this.foodName = entity.getFoodName();
        this.imgUrl = entity.getFoodImages().get(0).getImgUrl();
    }


    public String CountryIdxToString(Long idx){
        if(idx == 1) return "한식";
        else if(idx == 2) return "일식";
        else if(idx == 3) return "중식";
        else  return "양식";
    }
}
