package com.example.homekiri.like.dto;

import com.example.homekiri.media.model.Genre;
import com.example.homekiri.media.model.MediaActivity;
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
