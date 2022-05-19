package com.example.homekiri.media.model;

import com.example.homekiri.config.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="Media_Platform")
@Entity
public class MediaPlatform extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mediaIdx")
    private MediaActivity media;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platformIdx")
    private Platform platform;



    @Builder
    public MediaPlatform(Long idx, MediaActivity media, Platform platform ){
        this.idx = idx;
        this.media = media;
        this.platform = platform;
    }
}
