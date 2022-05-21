package com.example.OTTall.like.model;

import com.example.OTTall.config.Auditable;
import com.example.OTTall.media.model.MediaActivity;
import com.example.OTTall.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
