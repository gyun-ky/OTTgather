package com.example.OTTall.like.dto;

import com.example.OTTall.exercise.model.Difficulty;
import com.example.OTTall.exercise.model.WorkoutActivity;
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
