package com.loom.dailycal.repository;

import com.loom.dailycal.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepo extends JpaRepository<Sport, Integer> {
}
