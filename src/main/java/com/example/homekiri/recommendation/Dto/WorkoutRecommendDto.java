package com.example.homekiri.recommendation.Dto;

import com.example.homekiri.exercise.model.WorkoutActivity;
import com.example.homekiri.exercise.model.WorkoutImg;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkoutRecommendDto {
    private Long idx;
    private String type;
    private String exerciseName;
    private List<String> imgUrl;

    public WorkoutRecommendDto(WorkoutActivity entity){
        this.idx = entity.getIdx();
        this.type = entity.getType().getTypeName();
        this.exerciseName = entity.getExerciseName();
        this.imgUrl = new ArrayList<>();
        for(WorkoutImg url : entity.getWorkoutImgList())
            imgUrl.add(url.getImgUrl());
    }

}
