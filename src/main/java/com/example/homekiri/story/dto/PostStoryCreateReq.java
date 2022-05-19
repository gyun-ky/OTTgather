package com.example.homekiri.story.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostStoryCreateReq {
    private Long userIdx;

    //서브 카테고리 idx
    private Long storySubCategoryIdx;

    private String contents;

    private String imgUrl = null;

    private String videoUrl = null;


}
