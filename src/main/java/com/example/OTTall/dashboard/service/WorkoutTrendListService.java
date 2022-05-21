package com.example.OTTall.dashboard.service;

import com.example.OTTall.config.BaseException;
import com.example.OTTall.config.BaseResponseStatus;
import com.example.OTTall.dashboard.Dto.WorkoutTrendListResponseDto;
import com.example.OTTall.dashboard.repository.WorkoutTrendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 운동 트렌드 Service
 * @param Null
 * @return List<WorkoutTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class WorkoutTrendListService {
    private final WorkoutTrendListRepository workoutTrendListRepository;
    static int TREND_SIZE = 5;
    @Transactional
    public List<WorkoutTrendListResponseDto> returnWorkoutTrend() throws BaseException {

        if(workoutTrendListRepository.findAll().size() <TREND_SIZE)
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        List<WorkoutTrendListResponseDto> result = new ArrayList<>();

        for(int i = 0; i <TREND_SIZE;++i)
            result.add(workoutTrendListRepository.findAll().stream()
                    .map(WorkoutTrendListResponseDto::new)
                    .collect(Collectors.toList()).get(i));
        return result;
    }
}
