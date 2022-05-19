package com.example.homekiri.story.model;

import com.example.homekiri.config.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="StorySubCategory")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StorySubCategory extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="storyCategoryIdx")
    private StoryCategory storyCategory;

    @Column(name = "storySubCategoryName")
    private String storySubCategoryNAme;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storySubCategory")
    private List<Story> stories = new ArrayList<Story>();
}
