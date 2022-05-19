package com.example.homekiri.dashboard.model;

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
@Table(name = "DessertTrend")
public class  DessertTrend extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "dessertIdx")
    private Long dessertIdx;

    @Column(name = "dessertName")
    private String dessertName;

    @Column(name = "ranking")
    private int ranking;


    @Builder
    public DessertTrend(Long idx, Long dessertIdx, String dessertName, int ranking){
        this.idx = idx;
        this.dessertIdx = dessertIdx;
        this.dessertName = dessertName;
        this.ranking = ranking;
    }
}
