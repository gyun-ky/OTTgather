package com.example.homekiri.exercise.repository;

import com.example.homekiri.exercise.model.WorkoutActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRecommendListRepository extends JpaRepository<WorkoutActivity, Long> {
    List<WorkoutActivity> findWorkoutActivitiesByDifficultyIdxOrDifficultyIdx(Long idx1, Long idx2);
    List<WorkoutActivity> findWorkoutActivitiesByDifficultyIdx(Long idx);
    List<WorkoutActivity> findWorkoutActivitiesByTypeIdx(Long idx);
}
