package com.example.homekiri.dessert.repository;

import com.example.homekiri.dessert.model.DessertActivity;
import com.example.homekiri.dessert.model.NonDrink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DessertRecommendListRepository extends JpaRepository<DessertActivity, Long> {
    List<DessertActivity> findDessertActivitiesByDrink_Caffeine(String s);
    List<DessertActivity> findDessertActivitiesByNonDrinkIsNot(NonDrink s);
    List<DessertActivity> findDessertActivitiesByDrink_Flavor(String s);
    List<DessertActivity> findDessertActivitiesByDrink_TemperatureContains(String s);
    List<DessertActivity> findDessertActivitiesByDrink_DrinkName(String s);
    List<DessertActivity> findDessertActivitiesByDrink_DrinkNameOrDrink_DrinkName(String s1, String s2);
}
