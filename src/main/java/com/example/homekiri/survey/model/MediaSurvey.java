package com.example.homekiri.survey.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.survey.Dto.MediaRequestDto;
import com.example.homekiri.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "MediaPreference")
public class MediaSurvey extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    private int action;
    private int animation;
    private int classic;
    private int comedy;
    private int crime;
    private int drama;
    private int fantasy;
    private int horror;
    private int jtbc;
    private int kbs;
    private int mbc;
    private int netflix;
    private int romance;
    private int sbs;
    private int scienceFiction;
    private int tvShow;
    private int tving;
    private int tvn;
    private int watcha;
    private int wave;


    public MediaSurvey() {
    }

    public MediaSurvey(MediaRequestDto mediaRequestDto){
        this.action = mediaRequestDto.getAction();
        this.animation = mediaRequestDto.getAnimation();
        this.classic = mediaRequestDto.getClassic();
        this.comedy = mediaRequestDto.getComedy();
        this.crime = mediaRequestDto.getCrime();
        this.fantasy = mediaRequestDto.getFantasy();
        this.horror = mediaRequestDto.getHorror();
        this.jtbc = mediaRequestDto.getJtbc();
        this.kbs = mediaRequestDto.getKbs();
        this.mbc = mediaRequestDto.getMbc();
        this.netflix = mediaRequestDto.getNetflix();
        this.romance = mediaRequestDto.getRomance();
        this.sbs = mediaRequestDto.getSbs();
        this.scienceFiction = mediaRequestDto.getScienceFiction();
        this.tvShow = mediaRequestDto.getTvShow();
        this.tving = mediaRequestDto.getTving();
        this.tvn = mediaRequestDto.getTvn();
        this.watcha = mediaRequestDto.getWatcha();
        this.wave = mediaRequestDto.getWave();
    }

}
