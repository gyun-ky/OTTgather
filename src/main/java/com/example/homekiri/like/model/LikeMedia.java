package com.example.homekiri.like.model;

import com.example.homekiri.config.Auditable;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeMedia extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mediaIdx")
    private MediaActivity media;

}
