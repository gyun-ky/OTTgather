package com.example.OTTall.dashboard.repository;

import com.example.OTTall.dashboard.model.WorkoutTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutTrendListRepository extends JpaRepository<WorkoutTrend, Long> {
}
