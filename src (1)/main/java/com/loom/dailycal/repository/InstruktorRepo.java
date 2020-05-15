package com.loom.dailycal.repository;

import com.loom.dailycal.models.FitnesInstruktor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstruktorRepo extends JpaRepository<FitnesInstruktor, Integer> {
    public FitnesInstruktor findByUsername(String username);
}
