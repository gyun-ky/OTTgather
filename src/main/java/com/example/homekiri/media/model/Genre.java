package com.example.homekiri.media.model;

import com.example.homekiri.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Genre")
public class Genre extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private List<MediaActivity> medias;

    private String genreName;

    private String description;


}
