package com.example.OTTall.worldcup;


import com.example.OTTall.config.BaseException;
import com.example.OTTall.config.BaseResponse;
import com.example.OTTall.config.BaseResponseStatus;
import com.example.OTTall.library.JwtService;
import com.example.OTTall.worldcup.Dto.WorldCupResponseDto;
import com.example.OTTall.worldcup.Dto.WorldCupResultDto;
import com.example.OTTall.worldcup.Service.WorldCupResultService;
import com.example.OTTall.worldcup.Service.WorldCupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/worldCup")
public class WorldCupController {

    public final WorldCupResultService worldCupResultService;
    public final WorldCupService worldCupService;
    private final JwtService jwtService;

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


    @GetMapping("/{userIdx}")
    public ResponseEntity<? extends BaseResponse> worldCup(
            @PathVariable Long userIdx,
            @RequestParam("round") int round,
            @RequestParam("category") String category){

        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }



        try {
            List<WorldCupResponseDto> result = worldCupService.worldCupResponse(userIdx, round, category);
            return ResponseEntity.ok().body(new BaseResponse<>(result));

        } catch (BaseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }
    @PostMapping("/{userIdx}")
    public ResponseEntity<? extends BaseResponse> worldCupResult(
            @RequestBody WorldCupResultDto worldCupResultDto,
            @PathVariable Long userIdx,
            @RequestParam("category") String category){

        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }


        try{
            Long result = worldCupResultService.updateResult(worldCupResultDto, userIdx, category);
            return ResponseEntity.ok().body(new BaseResponse<>(result));

        }catch (BaseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }

    }
}
