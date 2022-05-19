package com.example.homekiri.recommendation.Dto;

import com.example.homekiri.media.model.MediaActivity;
import lombok.Getter;

@Getter
public class MediaRecommendDto {
    private Long idx;
    private String category;
    private String mediaName;
    private String imgUrl;

    public MediaRecommendDto(MediaActivity entity1){
        this.idx = entity1.getIdx();
        this.category = GenreIdxToGenre( entity1.getGenre().getIdx());
        this.mediaName = entity1.getMediaName();
        this.imgUrl = entity1.getMediaImages().get(0).getImgUrl();
    }
    public String GenreIdxToGenre(Long genreIdx){
        if(genreIdx == 1) return "SF";
        else if(genreIdx == 2) return "가족";
        else if(genreIdx == 3) return "공포(호러)";
        else if(genreIdx == 4) return "다큐멘터리";
        else if(genreIdx == 5) return "드라마";
        else if(genreIdx == 6) return "멜로/로맨스";
        else if(genreIdx == 7) return "뮤지컬";
        else if(genreIdx == 8) return "미스터리";
        else if(genreIdx == 9) return "범죄";
        else if(genreIdx == 10) return "사극";
        else if(genreIdx == 11) return "서부극(웨스턴)";
        else if(genreIdx == 12) return "스릴러";
        else if(genreIdx == 13) return "시사/교양";
        else if(genreIdx == 14) return "애니메이션";
        else if(genreIdx == 15) return "액션";
        else if(genreIdx == 16) return "어드벤처";
        else if(genreIdx == 17) return "예능";
        else if(genreIdx == 18) return "전쟁";
        else if(genreIdx == 19) return "코미디";
        else return "판타지";
    }
}
