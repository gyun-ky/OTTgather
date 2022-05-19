package com.example.homekiri.survey.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.survey.Dto.DessertRequestDto;
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
@Table(name = "DessertPreference")
public class DessertSurvey extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    private int coffee;
    private int nonCoffee;
    private int tea;
    private int smoothie;
    private int fruit;
    private int bakery;
    private int withIce;
    private int hot;
    private int cold;
    private int sweet;
    private int sour;
    private int bitter;


    public DessertSurvey() {
    }

    public DessertSurvey(DessertRequestDto dessertRequestDto){
        this.coffee = dessertRequestDto.getCoffee();
        this.nonCoffee = dessertRequestDto.getNonCoffee();
        this.tea = dessertRequestDto.getTea();
        this.smoothie = dessertRequestDto.getSmoothie();
        this.fruit = dessertRequestDto.getSmoothie();
        this.bakery = dessertRequestDto.getBakery();
        this.withIce = dessertRequestDto.getWithIce();
        this.hot = dessertRequestDto.getHot();
        this.cold = dessertRequestDto.getCold();
        this.sweet = dessertRequestDto.getSweet();
        this.sour = dessertRequestDto.getSour();
        this.bitter = dessertRequestDto.getBitter();
    }
}
