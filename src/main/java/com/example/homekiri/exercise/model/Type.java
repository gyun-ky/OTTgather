package com.example.homekiri.exercise.model;

import com.example.homekiri.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Type")
@Entity
public class Type extends Auditable {
    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<WorkoutActivity> workoutActivities;

    @Column(name="typeName")
    private String typeName;

    @Column(name="description")
    private String description;


}
