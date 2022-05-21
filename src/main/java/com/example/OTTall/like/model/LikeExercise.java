package com.example.OTTall.like.model;

import com.example.OTTall.config.Auditable;
import com.example.OTTall.exercise.model.WorkoutActivity;
import com.example.OTTall.user.model.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class LikeExercise extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseIdx")
    private WorkoutActivity workout;

}
