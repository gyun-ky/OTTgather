package com.example.homekiri.media.repository;

import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.media.model.MediaImage;
import com.example.homekiri.media.model.MediaPlatform;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
