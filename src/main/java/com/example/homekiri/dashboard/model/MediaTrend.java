package com.example.homekiri.dashboard.model;

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
@Entity
//@Builder
@Table(name="MediaTrend")
public class MediaTrend extends Auditable {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "mediaIdx")
    private Long mediaIdx;

    @Column(name = "mediaName")
    private String mediaName;

    @Column(name="ranking")
    private int ranking;


    @Builder
    public MediaTrend(Long idx, Long mediaIdx, String mediaName, int ranking){
        this.idx = idx;
        this.mediaIdx = mediaIdx;
        this.mediaName = mediaName;
        this.ranking = ranking;
    }
}
