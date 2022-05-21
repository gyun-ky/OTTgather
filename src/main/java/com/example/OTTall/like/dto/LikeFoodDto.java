package com.example.OTTall.like.dto;

import com.example.OTTall.food.model.Country;
import com.example.OTTall.food.model.FoodActivity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LikeFoodDto {

//    private Long foodIdx;
//
//    private String foodName;
//
//    private String category;
//
//    private List<FoodImage> foodImageUrl;

    private FoodActivity food;

    private Country country;

    private String imageUrl;

}
