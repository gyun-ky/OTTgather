package com.example.homekiri.story.model;

import com.example.homekiri.config.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
