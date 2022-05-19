package com.example.homekiri.exercise.repository;

import com.example.homekiri.preferences.WorkoutPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPreferenceRepository extends JpaRepository<WorkoutPreference, Long> {
}
