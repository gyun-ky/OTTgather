package com.example.homekiri.dessert.model;

import com.example.homekiri.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Drink")
@Entity
public class Drink extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "temparture")
    private String temperature;

    @Column(name = "caffeine")
    private String caffeine;

    @Column(name = "flavor")
    private String flavor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "drink")
    private List<DessertActivity> dessertActivityList;


    @Builder
    public Drink(Long idx, String drinkName, String temperature, String caffeine, String flavor){
        this.idx = idx;
        this.drinkName = drinkName;
        this.temperature = temperature;
        this.caffeine = caffeine;
        this.flavor = flavor;
    }
}
