package com.example.homekiri.media.repository;

import com.example.homekiri.preferences.MediaPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPreferenceRepository extends JpaRepository<MediaPreference, Long> {
}
