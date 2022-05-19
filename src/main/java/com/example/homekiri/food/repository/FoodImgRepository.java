package com.example.homekiri.food.repository;

import com.example.homekiri.food.model.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodImgRepository extends JpaRepository<FoodImage, Long> {
    FoodImage findFoodImageByFoodIdx(Long foodIdx);
}
