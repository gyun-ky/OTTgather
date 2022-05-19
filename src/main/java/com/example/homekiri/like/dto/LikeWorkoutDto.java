package com.example.homekiri.like.dto;

import com.example.homekiri.exercise.model.Difficulty;
import com.example.homekiri.exercise.model.WorkoutActivity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LikeWorkoutDto {
    private WorkoutActivity workoutActivity;
    private Difficulty difficulty;
    private String imageurl;
}
