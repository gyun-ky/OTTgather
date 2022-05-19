package com.example.homekiri.media;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.media.Dto.MediaActivityResponseDto;
import com.example.homekiri.media.service.MediaActivityDetailsService;
import com.example.homekiri.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class MediaSpecificActivityController {

    private final JwtService jwtService;
    private final MediaActivityDetailsService mediaActivityDetailsService;

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
     * 미디어 상세 설명 API
     * [GET] /web/details/{userIdx}/media/{mediaIdx}
     * @param Long mediaIdx, userIdx
     * @return BaseResponse<MediaActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/{userIdx}/media/{mediaIdx}")
    public ResponseEntity<? extends BaseResponse> returnMediaActivity(@PathVariable Long mediaIdx, @PathVariable Long userIdx, @RequestHeader String jwt){
        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }
        try{
            MediaActivityResponseDto result = mediaActivityDetailsService.findById(mediaIdx);
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        } catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

}
