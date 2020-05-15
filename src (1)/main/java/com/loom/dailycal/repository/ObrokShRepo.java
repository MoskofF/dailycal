package com.loom.dailycal.repository;

import com.loom.dailycal.models.ObrokSh;
import com.loom.dailycal.relations.ObrokShKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObrokShRepo extends JpaRepository<ObrokSh, ObrokShKey> {
}
