package com.example.OTTall.survey.Repository;

import com.example.OTTall.survey.model.MediaSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaSurveyRepository extends JpaRepository<MediaSurvey, Long> {
    Optional<MediaSurvey> findByUserIdx(Long userIdx);
}
