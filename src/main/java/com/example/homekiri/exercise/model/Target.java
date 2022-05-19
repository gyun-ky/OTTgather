package com.example.homekiri.exercise.model;


import com.example.homekiri.config.Auditable;
import com.example.homekiri.media.model.MediaActivity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Target")
@Entity
public class Target extends Auditable {
    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "target")
    private List<WorkoutActivity> workoutActivities;

    @Column(name = "targetName")
    private String targetName;


}
