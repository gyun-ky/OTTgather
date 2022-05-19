package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.FoodTrendListResponseDto;
import com.example.homekiri.dashboard.repository.FoodTrendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 음식 트렌드 Service
 * @param Null
 * @return List<FoodTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class FoodTrendListService {
    private final FoodTrendListRepository foodTrendListRepository;
    static int TREND_SIZE = 5;
    @Transactional
    public List<FoodTrendListResponseDto> returnFoodTrend() throws BaseException {

        if(foodTrendListRepository.findAll().size() < TREND_SIZE)
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        List<FoodTrendListResponseDto> result = new ArrayList<>();

        for(int i = 0; i <TREND_SIZE; i++)
            result.add(foodTrendListRepository.findAll().stream()
                    .map(FoodTrendListResponseDto::new)
                    .collect(Collectors.toList()).get(i));
        return result;
    }
}
