package com.example.homekiri.dessert.repository;

import com.example.homekiri.preferences.DessertPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertPreferenceRepository extends JpaRepository<DessertPreference, Long> {
}
