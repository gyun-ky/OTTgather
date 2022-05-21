package com.example.OTTall.survey.Repository;

import com.example.OTTall.survey.model.FoodSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodSurveyRepository extends JpaRepository<FoodSurvey, Long> {
    Optional<FoodSurvey> findByUserIdx(Long idx);
}
