package com.example.OTTall.media.repository;

import com.example.OTTall.media.model.MediaPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPlatformRepository extends JpaRepository<MediaPlatform, Long> {
    MediaPlatform findMediaPlatformByMediaIdx(Long mediaIdx);
}
