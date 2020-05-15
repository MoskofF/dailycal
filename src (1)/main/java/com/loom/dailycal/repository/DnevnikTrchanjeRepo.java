package com.loom.dailycal.repository;

import com.loom.dailycal.models.DnevnikRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnevnikTrchanjeRepo extends JpaRepository<DnevnikRun, Integer> {
}
