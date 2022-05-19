package com.example.homekiri.preferences;

import com.example.homekiri.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ExercisePreference")
public class WorkoutPreference extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "health")
    private Long health;

    @Column(name = "yoga")
    private Long yoga;

    @Column(name = "difficulty")
    private Long difficulty;


}
