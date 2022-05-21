package com.example.OTTall.survey.Service;


import com.example.OTTall.config.BaseException;
import com.example.OTTall.survey.Dto.DessertRequestDto;
import com.example.OTTall.survey.Repository.DessertSurveyRepository;
import com.example.OTTall.survey.model.DessertSurvey;

import com.example.OTTall.user.model.User;
import com.example.OTTall.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DessertSurveyService {
    private final DessertSurveyRepository dessertSurveyRepository;
    private final UserRepository userRepository;

    public Long updateDessertSurvey(DessertRequestDto dessertRequestDto, Long userIdx) throws BaseException {
//        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        User user = userRepository.findUserByIdx(userIdx);
        // 유저가 성향조사 이미 한경우
        //***//
        DessertSurvey dessertSurvey = new DessertSurvey(dessertRequestDto);
        dessertSurvey.setUser(user);
        return dessertSurveyRepository.save(dessertSurvey).getIdx();
    }
}
