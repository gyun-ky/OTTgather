package com.example.OTTall.dashboard.Dto;

import com.example.OTTall.dashboard.model.MediaTrend;
import lombok.Getter;

@Getter
public class MediaTrendListResponseDto {

    private Long idx;
    private Long mediaIdx;
    private int ranking;
    private String mediaName;

    public MediaTrendListResponseDto(MediaTrend entity){
        this.idx = entity.getIdx();
        this.mediaIdx = entity.getMediaIdx();
        this.ranking = entity.getRanking();
        this.mediaName = entity.getMediaName();
    }
}
