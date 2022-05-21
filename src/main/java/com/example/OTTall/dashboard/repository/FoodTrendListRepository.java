package com.example.OTTall.dashboard.repository;

import com.example.OTTall.dashboard.model.FoodTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTrendListRepository extends JpaRepository<FoodTrend, Long> {
}
