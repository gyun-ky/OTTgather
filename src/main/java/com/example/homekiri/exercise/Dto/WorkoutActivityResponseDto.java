package com.example.homekiri.exercise.Dto;

import com.example.homekiri.exercise.model.WorkoutActivity;
import com.example.homekiri.exercise.model.WorkoutImg;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkoutActivityResponseDto {
    private Long idx;
    private String Category;
    private String difficulty;
    private String target;
    private String exerciseName;
    private String description;
    private List<String> imgUrl;
    private List<String> videoUrl;

    public WorkoutActivityResponseDto(WorkoutActivity entity){
        this.idx = entity.getIdx();
        this.Category = entity.getType().getTypeName();
        this.difficulty = entity.getDifficulty().getStatus();
        this.target = entity.getTarget().getTargetName();
        this.exerciseName = entity.getExerciseName();
        this.description = entity.getDescription();
        this.imgUrl = new ArrayList<>();
        for(WorkoutImg url : entity.getWorkoutImgList())
            imgUrl.add(url.getImgUrl());

        this.videoUrl = new ArrayList<>();
        for(WorkoutImg url : entity.getWorkoutImgList())
            videoUrl.add(url.getImgUrl());
    }

}
