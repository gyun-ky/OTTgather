package com.example.homekiri.food.repository;

import com.example.homekiri.preferences.FoodPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Long> {
}
