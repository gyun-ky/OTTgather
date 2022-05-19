package com.example.homekiri.story.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.story.dto.PostStoryCreateReq;
import com.example.homekiri.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Story")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Story extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String contents;

    private String imgUrl = null;

    private String videoUrl = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="storySubCategoryIdx")
    private StorySubCategory storySubCategory;

    public static Story createStory(PostStoryCreateReq postStoryCreateReq, User user, StorySubCategory storySubCategory){

        Story newStory = new Story();
        newStory.setUser(user);
        newStory.setStorySubCategory(storySubCategory);
        newStory.setContents(postStoryCreateReq.getContents());
        newStory.setImgUrl(postStoryCreateReq.getImgUrl());
        newStory.setVideoUrl(postStoryCreateReq.getVideoUrl());

        return newStory;
    }

}
