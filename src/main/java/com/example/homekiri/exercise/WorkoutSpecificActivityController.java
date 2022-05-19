package com.example.homekiri.exercise;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.exercise.Dto.WorkoutActivityResponseDto;
import com.example.homekiri.exercise.service.WorkoutActivityDetailsService;
import com.example.homekiri.library.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class WorkoutSpecificActivityController {


    private final JwtService jwtService;
    private final WorkoutActivityDetailsService workoutActivityDetailsService;

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
     * 운동 상세 설명 API
     * [GET] /web/details/{userIdx}/workout/{workoutIdx}
     * @param Long workoutIdx, userIdx
     * @return BaseResponse<WorkoutActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/{userIdx}/workout/{workoutIdx}")
    public ResponseEntity<? extends BaseResponse> returnWorkoutActivity(@PathVariable Long workoutIdx, @PathVariable Long userIdx){
        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }


        try{
            WorkoutActivityResponseDto result = workoutActivityDetailsService.findById(workoutIdx);
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        } catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }
}
