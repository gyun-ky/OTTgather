package com.example.OTTall.media.service;

import com.example.OTTall.config.BaseException;
import com.example.OTTall.config.BaseResponseStatus;
import com.example.OTTall.media.Dto.MediaActivityResponseDto;
import com.example.OTTall.media.model.MediaActivity;
import com.example.OTTall.media.repository.MediaRecommendListRepository;
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
