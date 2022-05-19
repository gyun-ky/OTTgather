package com.example.homekiri.preferences;


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
@Entity
@Table(name = "DessertPreference")
public class DessertPreference extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "coffee")
    private Long coffee;

    @Column(name = "nonCoffee")
    private Long nonCoffee;

    @Column(name = "tea")
    private Long tea;

    @Column(name = "smoothie")
    private Long smoothie;

    @Column(name = "fruit")
    private Long fruit;

    @Column(name = "bakery")
    private Long bakery;

    @Column(name = "withIce")
    private Long withIce;

    @Column(name = "hot")
    private Long hot;

    @Column(name = "cold")
    private Long cold;

    @Column(name = "sweet")
    private Long sweet;

    @Column(name = "sour")
    private Long sour;

    @Column(name = "bitter")
    private Long bitter;


    @Builder
    public DessertPreference(Long idx, Long userIdx, Long coffee, Long nonCoffee, Long tea, Long smoothie, Long fruit, Long bakery, Long withIce, Long hot ,Long cold, Long sweet, Long sour, Long bitter){
        this.idx = idx;
        this.userIdx = userIdx;
        this.coffee = coffee;
        this.nonCoffee = nonCoffee;
        this.tea = tea;
        this.smoothie = smoothie;
        this.fruit = fruit;
        this.bakery = bakery;
        this.withIce = withIce;
        this.hot = hot;
        this.cold = cold;
        this.sweet = sweet;
        this.sour = sour;
        this.bitter = bitter;
    }

}
