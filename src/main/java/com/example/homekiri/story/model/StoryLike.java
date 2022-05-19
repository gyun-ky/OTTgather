package com.example.homekiri.story.model;

import com.example.homekiri.config.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="StoryLike")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoryLike extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private Long userIdx;

    private Long storyIdx;

    public StoryLike(Long userIdx, Long storyIdx){
        this.userIdx = userIdx;
        this.storyIdx = storyIdx;
    }
}
