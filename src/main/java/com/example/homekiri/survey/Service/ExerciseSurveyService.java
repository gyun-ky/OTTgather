package com.example.homekiri.survey.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.survey.Dto.ExerciseRequestDto;
import com.example.homekiri.survey.Repository.ExerciseSurveyRepository;
import com.example.homekiri.survey.model.ExerciseSurvey;

import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseSurveyService {
    public final ExerciseSurveyRepository exerciseSurveyRepository;
    public final UserRepository userRepository;

    public Long updateExerciseSurvey(ExerciseRequestDto exerciseRequestDto, Long userIdx) throws BaseException{
//        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        User user = userRepository.findUserByIdx(userIdx);
        ExerciseSurvey exerciseSurvey = new ExerciseSurvey(exerciseRequestDto);
        exerciseSurvey.setUser(user);
        return exerciseSurveyRepository.save(exerciseSurvey).getIdx();
    }
}
