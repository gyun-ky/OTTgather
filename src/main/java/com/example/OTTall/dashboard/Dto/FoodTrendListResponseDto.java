package com.example.OTTall.dashboard.Dto;

import com.example.OTTall.dashboard.model.FoodTrend;
import lombok.Getter;

@Getter
public class FoodTrendListResponseDto {

    private Long idx;
    private Long foodIdx;
    private int ranking;
    private String foodName;

    public FoodTrendListResponseDto(FoodTrend entity){
        this.idx = entity.getIdx();
        this.foodIdx = entity.getFoodIdx();
        this.ranking = entity.getRanking();
        this.foodName = entity.getFoodName();
    }
}
