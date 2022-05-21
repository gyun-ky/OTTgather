package com.example.OTTall.survey.Repository;

import com.example.OTTall.survey.model.ExerciseSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseSurveyRepository extends JpaRepository<ExerciseSurvey, Long> {

    Optional<ExerciseSurvey> findByUserIdx(Long idx);
}
