package com.example.OTTall.media.repository;

import com.example.OTTall.media.model.MediaImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MediaImgRepository extends JpaRepository<MediaImage, Long> {
    MediaImage findMediaImgByMediaIdx(Long MediaIdx);
}
