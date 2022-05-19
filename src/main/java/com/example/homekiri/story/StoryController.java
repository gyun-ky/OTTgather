package com.example.homekiri.story;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.story.dto.PostStoryCreateReq;
import com.example.homekiri.story.dto.PostStoryCreateRes;
import com.example.homekiri.story.dto.PostStoryLikeReq;
import com.example.homekiri.story.model.StorySubCategory;
import com.example.homekiri.user.UserController;
import com.example.homekiri.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/stories")
public class StoryController {
    // 다른 controller 참고
    private final StoryService storyService;
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public StoryController(StoryService storyService, JwtService jwtService, UserService userService){
        this.storyService = storyService;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    /**
     * Story 생성 API
     * [POST] /web/stories
     * @return BaseResponse<? extends BaseResponse>
     */
    @ResponseBody
    @PostMapping("")
    public ResponseEntity<? extends BaseResponse> createStory(@RequestBody PostStoryCreateReq postStoryCreateReq){
        try {
            if (!userService.jwtAuth(postStoryCreateReq.getUserIdx())) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{

            PostStoryCreateRes result = storyService.createStory(postStoryCreateReq);
            System.out.println("[POST] createStory complete");
            return ResponseEntity.ok().body(new BaseResponse(result));

        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse(e.getStatus()));
        }
    }

    /**
     * 마이페이지 API
     * [POST] /web/stories/like
     * @return BaseResponse<? extends BaseResponse>
     */
    @ResponseBody
    @PostMapping("/like")
    public ResponseEntity<? extends BaseResponse> createStoryLike(@RequestBody PostStoryLikeReq postStoryLikeReq) {
        try {
            if (!userService.jwtAuth(postStoryLikeReq.getUserIdx())) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponse<>(e.getStatus()));
        }

        try{
            storyService.createStoryLike(postStoryLikeReq);
            return ResponseEntity.ok().body(new BaseResponse(new PostStoryCreateRes(postStoryLikeReq.getStoryIdx())));
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse(e.getStatus()));
        }
    }

}
