package com.example.homekiri.survey.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.survey.Dto.FoodRequestDto;
import com.example.homekiri.survey.Repository.FoodSurveyRepository;
import com.example.homekiri.survey.model.FoodSurvey;

import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodSurveyService {
    private final FoodSurveyRepository foodSurveyRepository;
    private final UserRepository userRepository;

    public Long updateFoodSurvey(FoodRequestDto foodRequestDto, Long userIdx) throws BaseException {
//        User user = userRepository.findByIdx(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        User user = userRepository.findUserByIdx(userIdx);
        // 유저가 성향조사 이미 한경우
        //***//
        FoodSurvey foodSurvey = new FoodSurvey(foodRequestDto);
        foodSurvey.setUser(user);
        return foodSurveyRepository.save(foodSurvey).getIdx();
    }
}
