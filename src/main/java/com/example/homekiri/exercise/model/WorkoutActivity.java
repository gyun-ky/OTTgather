package com.example.homekiri.exercise.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.like.model.LikeExercise;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Exercise")
@Entity
public class WorkoutActivity extends Auditable {
    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeIdx")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "difficultyIdx")
    private Difficulty difficulty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "targetIdx")
    private Target target;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workout")
    private List<LikeExercise> likeExercises = new ArrayList<>();

    @Column(name="exerciseName")
    private String exerciseName;

    @Column(name="description")
    private String description;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workoutActivity", cascade = CascadeType.ALL)
    private List<WorkoutImg> workoutImgList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workoutActivity", cascade = CascadeType.ALL)
    private List<WorkoutVideo> workoutVideoList = new ArrayList<>();



    @Builder
    public WorkoutActivity(Long idx, Type type, Difficulty difficulty, Target target, String exerciseName, String description){
        this.idx = idx;
        this.type = type;
        this.difficulty = difficulty;
        this.target  =target;
        this.exerciseName = exerciseName;
        this.description = description;
    }
}
