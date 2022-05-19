package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.FoodSurvey;
import com.example.homekiri.survey.model.MediaSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaSurveyRepository extends JpaRepository<MediaSurvey, Long> {
    Optional<MediaSurvey> findByUserIdx(Long userIdx);
}
