package com.example.homekiri.food.model;

import com.example.homekiri.config.Auditable;
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
@Table(name="Food")
@Entity
public class FoodActivity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryIdx")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodImage> foodImages = new ArrayList<>();

    @Column(name="foodName")
    private String foodName;

    @Column(name="description")
    private String description;

    @Column(name="ingredient")
    private String ingredient;

    @Column(name="recipe")
    private String recipe;

    @Column(name="temparture")
    private String temperature;

    @Column(name="cookingState")
    private String cookingState;


    @Builder
    public FoodActivity(Long idx, Country country, String foodName, String description , String ingredient, String recipe, String temperature, String cookingState){
        this.idx = idx;
        this.country = country;
        this.foodName = foodName;
        this.description = description;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.temperature = temperature;
        this.cookingState = cookingState;
    }
}

