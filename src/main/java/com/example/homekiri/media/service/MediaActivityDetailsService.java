package com.example.homekiri.media.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.media.Dto.MediaActivityResponseDto;
import com.example.homekiri.media.model.MediaPlatform;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.media.repository.MediaPlatformRepository;
import com.example.homekiri.media.repository.MediaRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MediaActivityDetailsService {
    private final MediaRecommendListRepository mediaRecommendListRepository;

    /**
     * 미디어 상세 설명 Service
     * @param Long idx
     * @return MediaActivityResponseDto
     */
    @Transactional
    public MediaActivityResponseDto findById(Long idx) throws BaseException {
        if(idx == -1)
            throw new BaseException(BaseResponseStatus.MEDIA_DATA_LACK_ERROR);
        MediaActivity res1 = mediaRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        return new MediaActivityResponseDto(res1);
    }
}
