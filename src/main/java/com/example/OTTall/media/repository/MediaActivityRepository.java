package com.example.OTTall.media.repository;

import com.example.OTTall.media.model.MediaActivity;
import com.example.OTTall.media.model.MediaImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MediaActivityRepository extends JpaRepository<MediaActivity, Long> {
    @Query("select M from MediaActivity M join fetch M.genre WHERE M.genre.genreName = :genreName")
    List<MediaActivity> findMedia(@Param("genreName") String genreName);

    @Query("select M from MediaImage M WHERE M.media.idx = :idx")
    List<MediaImage> findUrlByIdx(@Param("idx") Long idx);

    @Query("select M.media from MediaPlatform M join M.media join M.platform " +
            "WHERE M.platform.platformName = :platform")
    List<MediaActivity> findByPlatform(@Param("platform") String platform);
}
