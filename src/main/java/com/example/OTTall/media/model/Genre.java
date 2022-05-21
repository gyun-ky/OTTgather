package com.example.OTTall.media.model;

import com.example.OTTall.config.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
