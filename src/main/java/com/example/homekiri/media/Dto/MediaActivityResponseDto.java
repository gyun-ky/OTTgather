package com.example.homekiri.media.Dto;

import com.example.homekiri.media.model.MediaImage;
import com.example.homekiri.media.model.MediaPlatform;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.media.model.Platform;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


@Getter
public class MediaActivityResponseDto {

    private Long idx;
    private String genre;
    private String mediaName;
    private int screeningYear;
    private String country;
    private List<String> actorList;
    private List<String> platforms;
    private String description;
    private List<String> imgUrl;


    public MediaActivityResponseDto(MediaActivity entity1){
        this.idx = entity1.getIdx();
        this.genre = entity1.getGenre().getGenreName();
        this.mediaName = entity1.getMediaName();
        this.screeningYear = entity1.getScreeningYear();
        this.country = entity1.getCountry();
        this.actorList = CommaParsing(entity1.getActorList());
        this.platforms = new ArrayList<>();
        for(MediaPlatform a: entity1.getMediaPlatformList())
            platforms.add(a.getPlatform().getPlatformName());
        this.description = entity1.getDescription();
        for(MediaImage a: entity1.getMediaImages())
            this.imgUrl.add(a.getImgUrl());
    }

    public List<String> CommaParsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, ", ");
        while(st1.hasMoreTokens()) {
            res.add(st1.nextToken());
        }
        return res;
    }

}
