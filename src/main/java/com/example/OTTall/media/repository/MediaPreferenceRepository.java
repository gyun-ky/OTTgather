package com.example.OTTall.media.repository;

import com.example.OTTall.preferences.MediaPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPreferenceRepository extends JpaRepository<MediaPreference, Long> {
}
