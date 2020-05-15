package com.loom.dailycal.repository;

import com.loom.dailycal.models.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepo extends JpaRepository<Trening, Integer> {
}
