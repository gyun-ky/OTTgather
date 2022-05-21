package com.example.OTTall.preferences;

import com.example.OTTall.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ExercisePreference")
public class WorkoutPreference extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "health")
    private Long health;

    @Column(name = "yoga")
    private Long yoga;

    @Column(name = "difficulty")
    private Long difficulty;


}
