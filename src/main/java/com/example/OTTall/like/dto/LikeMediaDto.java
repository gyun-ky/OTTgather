package com.example.OTTall.like.dto;

import com.example.OTTall.media.model.Genre;
import com.example.OTTall.media.model.MediaActivity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LikeMediaDto {
    private MediaActivity media;
    private Genre genre;
    private String imageUrl;
}
