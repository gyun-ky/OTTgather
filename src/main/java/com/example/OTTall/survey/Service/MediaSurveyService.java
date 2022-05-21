package com.example.OTTall.survey.Service;


import com.example.OTTall.config.BaseException;
import com.example.OTTall.survey.Dto.MediaRequestDto;
import com.example.OTTall.survey.Repository.MediaSurveyRepository;
import com.example.OTTall.survey.model.MediaSurvey;
import com.example.OTTall.user.model.User;
import com.example.OTTall.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MediaSurveyService {
    public final MediaSurveyRepository mediaSurveyRepository;
    public final UserRepository userRepository;

    public Long updateMediaSurvey(MediaRequestDto mediaRequestDto, Long userIdx) throws BaseException{
//        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        User user = userRepository.findUserByIdx(userIdx);
        MediaSurvey mediaSurvey = new MediaSurvey(mediaRequestDto);
        mediaSurvey.setUser(user);
        return mediaSurveyRepository.save(mediaSurvey).getIdx();
    }
}
