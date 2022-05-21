package com.example.OTTall.dashboard.model;

import com.example.OTTall.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "WorkoutTrend")
public class WorkoutTrend extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "workoutIdx")
    private Long workoutIdx;

    @Column(name = "workoutName")
    private String workoutName;

    @Column(name = "ranking")
    private int ranking;
    @Builder
    public WorkoutTrend(Long idx, Long workoutIdx, String workoutName, int ranking){
        this.idx = idx;
        this.workoutIdx = workoutIdx;
        this.workoutName = workoutName;
        this.ranking = ranking;
    }
}
