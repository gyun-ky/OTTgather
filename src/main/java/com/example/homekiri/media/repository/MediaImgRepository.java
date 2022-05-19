package com.example.homekiri.media.repository;

import com.example.homekiri.media.model.MediaImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MediaImgRepository extends JpaRepository<MediaImage, Long> {
    MediaImage findMediaImgByMediaIdx(Long MediaIdx);
}
