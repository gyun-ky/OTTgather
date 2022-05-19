package com.example.homekiri.user.dto;

import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.like.dto.LikeFoodDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MypageLikeFood {

    private Long idx;
    private String name;
    private String category;
    private String imageUrl;

    public MypageLikeFood(LikeFoodDto likeFoodDto){
        FoodActivity food = likeFoodDto.getFood();
        this.idx = food.getIdx();
        this.name = food.getFoodName();
        this.category = likeFoodDto.getCountry().getCountryName();
        this.imageUrl = likeFoodDto.getImageUrl();
    }
}
