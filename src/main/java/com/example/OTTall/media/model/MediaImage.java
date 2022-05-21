package com.example.OTTall.media.model;

import com.example.OTTall.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name="MediaImage")
@Entity
public class MediaImage extends Auditable {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mediaIdx")
    private MediaActivity media;

    @Column(name = "description")
    private String description;

    @Column(name = "imgUrl")
    private String imgUrl;


    @Builder
    public MediaImage(Long idx, MediaActivity media, String description, String imgUrl){
        this.idx = idx;
        this.media = media;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
