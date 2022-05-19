package com.example.homekiri.dessert.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.exercise.model.WorkoutImg;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Dessert")
@Entity
public class DessertActivity extends Auditable {

    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="drinkIdx", nullable = true)
    private Drink drink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="nonDrinkIdx", nullable = true)
    private NonDrink nonDrink;

    @Column(name="dessertName")
    private String dessertName;

    @Column(name="description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dessertActivity", cascade = CascadeType.ALL)
    private List<DessertImage> dessertImageList = new ArrayList<>();


    @Builder
    public DessertActivity(Long idx, Long drinkIdx, Long nonDrinkIdx, String dessertName , String description){
        this.idx = idx;
        this.dessertName = dessertName;
        this.description = description;
    }
}
