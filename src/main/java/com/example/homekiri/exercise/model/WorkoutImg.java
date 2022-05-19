package com.example.homekiri.exercise.model;

import com.example.homekiri.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="ExerciseImage")
@Entity
public class WorkoutImg extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseIdx")
    private WorkoutActivity workoutActivity;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;


//    @Builder
//    public WorkoutImg(Long idx, Long exerciseIdx, String imgUrl, String description, LocalDateTime updatedAt, LocalDateTime createdAt){
//        this.idx = idx;
//        this.exerciseIdx = exerciseIdx;
//        this.imgUrl = imgUrl;
//        this.description = description;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
}
