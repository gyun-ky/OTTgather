package com.example.OTTall.survey.model;


import com.example.OTTall.config.Auditable;
import com.example.OTTall.survey.Dto.FoodRequestDto;
import com.example.OTTall.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="FoodPreference")
public class FoodSurvey extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    private int china;
    private int japan;
    private int western;
    private int korea;
    private int noodle;
    private int pork;
    private int beef;
    private int chicken;
    private int rice;
    private int seaFood;
    private int soup;
    private int temperature;
    private int raw;
    private int roasted;


    public FoodSurvey() {
    }

    public FoodSurvey(FoodRequestDto foodRequestDto){
        this.china = foodRequestDto.getChina();
        this.japan = foodRequestDto.getJapan();
        this.western = foodRequestDto.getWestern();
        this.korea = foodRequestDto.getKorea();
        this.noodle = foodRequestDto.getNoodle();
        this.pork = foodRequestDto.getPork();
        this.beef = foodRequestDto.getBeef();
        this.chicken = foodRequestDto.getChicken();
        this.rice = foodRequestDto.getRice();
        this.seaFood = foodRequestDto.getSeaFood();
        this.soup = foodRequestDto.getSoup();
        this.temperature = foodRequestDto.getTemperature();
        this.raw = foodRequestDto.getRaw();
        this.roasted = foodRequestDto.getRoasted();
    }
}
