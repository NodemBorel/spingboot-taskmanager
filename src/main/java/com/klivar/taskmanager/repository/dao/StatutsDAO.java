package com.klivar.taskmanager.repository.dao;

import com.klivar.taskmanager.repository.entity.StatutsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutsDAO extends JpaRepository<StatutsEntity, Long> {
}
