package com.example.homekiri.dashboard.repository;

import com.example.homekiri.dashboard.model.WorkoutTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutTrendListRepository extends JpaRepository<WorkoutTrend, Long> {
}
