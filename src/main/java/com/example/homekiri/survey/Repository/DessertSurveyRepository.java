package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.DessertSurvey;
import com.example.homekiri.survey.model.FoodSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertSurveyRepository extends JpaRepository<DessertSurvey, Long> {
}
