package com.example.homekiri.user.dto;

import com.example.homekiri.like.dto.LikeMediaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MypageLikeMedia {
    private Long idx;
    private String name;
    private String genre;
    private String imageUrl;

    public MypageLikeMedia(LikeMediaDto likeMediaDto){
        this.idx = likeMediaDto.getMedia().getIdx();
        this.name = likeMediaDto.getMedia().getMediaName();
        this.genre = likeMediaDto.getGenre().getGenreName();
        this.genre = likeMediaDto.getImageUrl();
    }
}
