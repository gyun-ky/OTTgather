package com.example.OTTall.survey.model;

import com.example.OTTall.config.Auditable;
import com.example.OTTall.survey.Dto.ExerciseRequestDto;
import com.example.OTTall.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ExercisePreference")
public class ExerciseSurvey extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    private int difficulty;
    private int health;
    private int yoga;


    public ExerciseSurvey() {
    }

    public ExerciseSurvey(ExerciseRequestDto exerciseRequestDto){
        this.difficulty = exerciseRequestDto.getDifficulty();
        this.health = exerciseRequestDto.getHealth();
        this.yoga = exerciseRequestDto.getYoga();
    }
}
