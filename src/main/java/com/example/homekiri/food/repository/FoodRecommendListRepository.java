package com.example.homekiri.food.repository;


import com.example.homekiri.food.model.FoodActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRecommendListRepository extends JpaRepository<FoodActivity, Long> {
    List<FoodActivity> findFoodActivitiesByIngredient(String s);
    List<FoodActivity> findFoodActivitiesByCountryIdx(Long idx);
    List<FoodActivity> findFoodActivitiesByTemperature(String s);
    List<FoodActivity> findFoodActivitiesByTemperatureOrTemperature(String s1, String s2);
    List<FoodActivity> findFoodActivitiesByCookingStateContains(String s);
}
