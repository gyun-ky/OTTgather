package com.example.homekiri.like.dto;

import com.example.homekiri.food.model.Country;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
