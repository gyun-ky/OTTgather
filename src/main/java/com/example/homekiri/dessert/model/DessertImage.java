package com.example.homekiri.dessert.model;

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
@Table(name="DessertImage")
@Entity
public class DessertImage extends Auditable {

    @Id
    @Column(name ="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dessertIdx")
    private DessertActivity dessertActivity;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;


    @Builder
    public DessertImage(Long idx, String description, String imgUrl){
        this.idx = idx;
        this.imgUrl =  imgUrl;
        this.description = description;
    }
}
