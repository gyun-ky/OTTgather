package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.repository.DessertTrendListRepository;
import com.example.homekiri.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 디저트 트렌드 Service
 * @param Null
 * @return List<DessertTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class DessertTrendListService {
    private final DessertTrendListRepository dessertTrendListRepository;
    static int TREND_SIZE = 5;
    @Transactional
    public List<DessertTrendListResponseDto> returnDessertTrend()  throws BaseException {

        if(dessertTrendListRepository.findAll().size() < TREND_SIZE)
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        List<DessertTrendListResponseDto> result = new ArrayList<>();

        for(int i = 0; i < TREND_SIZE; ++i)
            result.add(dessertTrendListRepository.findAll().stream()
                    .map(DessertTrendListResponseDto::new)
                    .collect(Collectors.toList()).get(i));

        return result;
    }

}
