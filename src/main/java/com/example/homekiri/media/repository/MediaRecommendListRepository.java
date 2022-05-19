package com.example.homekiri.media.repository;

import com.example.homekiri.media.model.MediaActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRecommendListRepository extends JpaRepository<MediaActivity, Long> {
    List<MediaActivity> findMediaActivitiesByGenreIdx(Long idx);
    List<MediaActivity> findMediaActivitiesByGenreIdxOrGenreIdx(Long idx1, Long idx2);
}
