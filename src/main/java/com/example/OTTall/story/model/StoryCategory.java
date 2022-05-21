package com.example.OTTall.story.model;

import com.example.OTTall.config.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="StoryCategory")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoryCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storyCategory")
    private List<StorySubCategory> storySubCategories = new ArrayList<>();

}
