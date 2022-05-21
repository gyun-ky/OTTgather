package com.example.OTTall.dashboard.model;

import com.example.OTTall.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//@Builder
@Table(name="FoodTrend")
public class FoodTrend extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "foodIdx")
    private Long foodIdx;

    @Column(name = "foodName")
    private String foodName;

    @Column(name = "ranking")
    private int ranking;


    @Builder
    public FoodTrend(Long idx, Long foodIdx, String foodName, int ranking){
        this.idx = idx;
        this.foodIdx = foodIdx;
        this.foodName = foodName;
        this.ranking = ranking;
    }
}
