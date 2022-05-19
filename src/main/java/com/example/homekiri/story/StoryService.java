package com.example.homekiri.story;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.story.dto.PostStoryCreateReq;
import com.example.homekiri.story.dto.PostStoryCreateRes;
import com.example.homekiri.story.dto.PostStoryLikeReq;
import com.example.homekiri.story.model.Story;
import com.example.homekiri.story.model.StoryLike;
import com.example.homekiri.story.model.StorySubCategory;
import com.example.homekiri.story.repository.StoryRepository;
import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoryService {

    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository, UserRepository userRepository){
        this.storyRepository = storyRepository;
        this.userRepository = userRepository;
    }


    /**
     스토리 등록 Service
     @param PostStoryCreateReq
     @return PostStoryCreateRes
     */
    @Transactional(rollbackFor = Exception.class)
    public PostStoryCreateRes createStory(PostStoryCreateReq postStoryCreateReq) throws BaseException{
        // storySubCategory Select해오기
        try {
            StorySubCategory storySubCategory = storyRepository.findStorySubCategoryByIdx(postStoryCreateReq.getStorySubCategoryIdx());
            // user select 해오기
            User user = userRepository.findUserByIdx(postStoryCreateReq.getUserIdx());
            //Story 만들기
            Story newStory = Story.createStory(postStoryCreateReq, user, storySubCategory);
            storyRepository.save(newStory);
            Long storyIdx = newStory.getIdx();

            return new PostStoryCreateRes(storyIdx);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }

    }


    /**
     스토리 좋아요 등록
     @param PostStoryLikeReq
     @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void createStoryLike(PostStoryLikeReq postStoryLikeReq) throws BaseException{
        try{
            StoryLike newLike = new StoryLike(postStoryLikeReq.getUserIdx(), postStoryLikeReq.getStoryIdx());
            storyRepository.saveLike(newLike);
            System.out.println("[SERVICE] storyLike complete");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
