package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.FoodSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

public interface FoodSurveyRepository extends JpaRepository<FoodSurvey, Long> {
    Optional<FoodSurvey> findByUserIdx(Long idx);
}
