package com.example.homekiri.food.Dto;

import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class FoodActivityResponseDto {

    private Long idx;
    private String country;
    private String foodName;
    private String description;
    private String ingredient;
    private List<String> recipe;
    private String temperature;
    private String cookingState;
    private List<String> imgUrl;

    public FoodActivityResponseDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.country = entity.getCountry().getCountryName();
        this.foodName = entity.getFoodName();
        this.description = entity.getDescription();
        this.ingredient = entity.getIngredient();
        this.recipe = Parsing(entity.getRecipe());
        this.temperature = entity.getTemperature();
        this.cookingState = entity.getCookingState();
        for(FoodImage a: entity.getFoodImages())
            this.imgUrl.add(a.getImgUrl());
    }

    //recipe parsing by "delim"
    public List<String> Parsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, "delim");
        while(st1.hasMoreTokens()){
            res.add(st1.nextToken());
        }
        return res;
    }

}
