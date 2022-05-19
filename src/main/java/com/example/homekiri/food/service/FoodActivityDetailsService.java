package com.example.homekiri.food.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.food.Dto.FoodActivityResponseDto;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.repository.FoodRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FoodActivityDetailsService {
    private final FoodRecommendListRepository foodRecommendListRepository;
    /**
     * 음식 상세 설명 Service
     * @param Long idx
     * @return FoodActivityResponseDto
     */
    @Transactional
    public FoodActivityResponseDto findById(Long idx) throws BaseException {
        FoodActivity res = foodRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        return new FoodActivityResponseDto(res);
    }
}
