package com.example.homekiri.dashboard.Dto;

import com.example.homekiri.dashboard.model.DessertTrend;
import lombok.Getter;

@Getter
public class DessertTrendListResponseDto {

    private Long idx;
    private Long dessertIdx;
    private int ranking;
    private String dessertName;

    public DessertTrendListResponseDto(DessertTrend entity){
        this.idx = entity.getIdx();
        this.dessertIdx = entity.getDessertIdx();
        this.ranking = entity.getRanking();
        this.dessertName = entity.getDessertName();
    }
}
