package com.example.homekiri.exercise.model;


import com.example.homekiri.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="ExerciseVideo")
@Entity
public class WorkoutVideo extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseIdx")
    private WorkoutActivity workoutActivity;

    @Column(name = "videoUrl")
    private String videoUrl;

    @Column(name = "description")
    private String description;


}
