package com.example.homekiri.dashboard;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.FoodTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.WorkoutTrendListResponseDto;
import com.example.homekiri.dashboard.service.DessertTrendListService;
import com.example.homekiri.dashboard.service.FoodTrendListService;
import com.example.homekiri.dashboard.service.MediaTrendListService;
import com.example.homekiri.dashboard.service.WorkoutTrendListService;
import com.example.homekiri.library.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/dashboard")
public class TrendListController {
    private final JwtService jwtService;

    private final MediaTrendListService mediaTrendListService;
    private final FoodTrendListService foodTrendListService;
    private final DessertTrendListService dessertTrendListService;
    private final WorkoutTrendListService workoutTrendListService;

    /**
     JWT 인증 메서드
     @param String JWT
     @return BOOLEAN
     */
    public boolean jwtAuth(Long userIdx) throws BaseException{
        try {
            Long jwtUserIdx = this.jwtService.getUserIdx();
            if(jwtUserIdx == userIdx){
                return true;
            }
            else{
                return false;
            }
        }catch (BaseException e){
            throw new BaseException(e.getStatus());
        }

    }


    /**
     * 미디어 트렌드 리스트 API
     * [GET] /web/dashboard/{userIdx}/media-trend-list
     * @param Long userIdx
     * @return BaseResponse<List<MediaTrendListResponseDto>>
     * if (MediaTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/{userIdx}/media-trend-list")
    public ResponseEntity<? extends BaseResponse> returnMediaTrend(@PathVariable Long userIdx){

        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{
            List<MediaTrendListResponseDto> result = mediaTrendListService.returnMediaTrend();
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }
        catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

    /**
     * 음식 트렌드 리스트 API
     * [GET] /web/dashboard/food-trend-
     * @param Long userIdx
     * @return BaseResponse<List<FoodTrendListResponseDto>>
     * if (FoodTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/{userIdx}/food-trend-list")
    public ResponseEntity<? extends BaseResponse> returnFoodTrend(@PathVariable Long userIdx){

        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{
            List<FoodTrendListResponseDto> result = foodTrendListService.returnFoodTrend();
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }
        catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

    /**
     * 디저트 트렌드 리스트 API
     * [GET] /web/dashboard/{userIdx}/dessert-trend-list
     * @param Long userIdx
     * @return BaseResponse<List<DessertTrendListResponseDto>>
     * if (DessertTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/{userIdx}/dessert-trend-list")
    public ResponseEntity<? extends BaseResponse> returnDessertTrend(@PathVariable Long userIdx){
        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{
            List<DessertTrendListResponseDto> result = dessertTrendListService.returnDessertTrend();
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }
        catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

    /**
     * 운동 트렌드 리스트 API
     * [GET] /web/dashboard/{userIdx}/workout-trend-list
     * @param Long userIdx
     * @return BaseResponse<List<WorkoutTrendListResponseDto>>
     * if (WorkoutTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/{userIdx}/workout-trend-list")
    public ResponseEntity<? extends BaseResponse> returnWorkoutTrend(@PathVariable Long userIdx){
        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{
            List<WorkoutTrendListResponseDto> result = workoutTrendListService.returnWorkoutTrend();
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }
        catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }
}
