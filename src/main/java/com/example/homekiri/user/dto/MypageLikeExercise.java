package com.example.homekiri.user.dto;

import com.example.homekiri.like.dto.LikeWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MypageLikeExercise {
    private Long idx;
    private String name;
    private String difficulty;
    private String imageUrl;

    public MypageLikeExercise(LikeWorkoutDto likeWorkoutDto){
        this.idx = likeWorkoutDto.getWorkoutActivity().getIdx();
        this.name = likeWorkoutDto.getWorkoutActivity().getExerciseName();
        this.difficulty = likeWorkoutDto.getWorkoutActivity().getDifficulty().getStatus();
        this.imageUrl = likeWorkoutDto.getImageurl();
    }
}

