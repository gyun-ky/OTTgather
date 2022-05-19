package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.user.dto.*;
import com.example.homekiri.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }




    /**
     * 회원가입 API
     * [POST] /web/users
     * @return BaseResponse<PostSignInRes>
     */
    @ResponseBody
    @PostMapping("/sign-in")
    public ResponseEntity<? extends BaseResponse> signIn(@RequestBody PostSignInReq postSignInReq){

        try{
            String encodedPassWord = userService.encodePassWord(postSignInReq.getPwd());
            User user = new User(postSignInReq, encodedPassWord);
            Long userIdx = userService.signIn(user);
            String jwt = jwtService.createJwt(userIdx);
            PostSignInRes result = new PostSignInRes(userIdx, jwt);
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

    /**
     * 로그인 API
     * [POST] /web/users/log-in
     * @return BaseResponse<PostLogInRes>
     */
    @ResponseBody
    @PostMapping("/log-in")
    public ResponseEntity<? extends BaseResponse> logIn(@RequestBody PostLogInReq postLogInReq){
        try{
            PostLogInRes result = userService.logIn(postLogInReq.getEmail(), postLogInReq.getPassword());
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }
    }

    /**
     * 마이페이지 API
     * [GET] /web/users/mypage/{userIdx}
     * @return BaseResponse<GetMypageRes>
     */
    @ResponseBody
    @GetMapping("/mypage/{userIdx}")
    public ResponseEntity<? extends BaseResponse> mypage(@PathVariable Long userIdx){
        //jwt 인증
        try {
            if (!userService.jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }


        try {
            GetMypageRes result = userService.getMypageInfo(userIdx);
            return ResponseEntity.ok().body(new BaseResponse<>(result));
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(e.getStatus()));
        }

    }



}
