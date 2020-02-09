package com.loom.dailycal.repository;

import com.loom.dailycal.models.ObrokSp;
import com.loom.dailycal.relations.ObrokSpKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObrokSpRepo extends JpaRepository<ObrokSp, ObrokSpKey> {
}
