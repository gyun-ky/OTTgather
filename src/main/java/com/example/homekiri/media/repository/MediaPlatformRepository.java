package com.example.homekiri.media.repository;

import com.example.homekiri.media.model.MediaPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPlatformRepository extends JpaRepository<MediaPlatform, Long> {
    MediaPlatform findMediaPlatformByMediaIdx(Long mediaIdx);
}
