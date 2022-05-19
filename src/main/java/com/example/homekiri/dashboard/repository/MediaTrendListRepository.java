package com.example.homekiri.dashboard.repository;

import com.example.homekiri.dashboard.model.MediaTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTrendListRepository extends JpaRepository<MediaTrend, Long> {
}
