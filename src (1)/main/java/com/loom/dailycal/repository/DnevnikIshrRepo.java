package com.loom.dailycal.repository;

import com.loom.dailycal.models.DnevnikIshrana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnevnikIshrRepo extends JpaRepository<DnevnikIshrana, Integer> {
}
