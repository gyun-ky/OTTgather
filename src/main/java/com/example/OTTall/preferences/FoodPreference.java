package com.example.OTTall.preferences;

import com.example.OTTall.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "FoodPreference")
public class FoodPreference extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "china")
    private Long china;

    @Column(name = "japan")
    private Long japan;

    @Column(name = "western")
    private Long western;

    @Column(name = "korea")
    private Long korea;

    @Column(name = "noodle")
    private Long noodle;

    @Column(name = "pork")
    private Long pork;

    @Column(name = "beef")
    private Long beef;

    @Column(name = "chicken")
    private Long chicken;

    @Column(name = "rice")
    private Long rice;

    @Column(name = "seaFood")
    private Long seaFood;

    @Column(name = "soup")
    private Long soup;

    @Column(name = "temperature")
    private Long temperature;

    @Column(name = "raw")
    private Long raw;

    @Column(name = "roasted")
    private Long roasted;


}

