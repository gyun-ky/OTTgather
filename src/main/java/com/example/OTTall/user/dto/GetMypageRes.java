package com.example.OTTall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GetMypageRes {
    private String nickname;
    private String profileImageUrl;

    private List<MypageLikeFood> likeFoods = null;
    private List<MypageLikeMedia> likeMedias = null;
    private List<MypageLikeExercise> likeExercises = null;

}


