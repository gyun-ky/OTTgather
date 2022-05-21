package com.example.OTTall.story.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostStoryLikeReq {
    private Long userIdx;
    private Long storyIdx;
}
