package com.klivar.taskmanager.repository.dao;

import com.klivar.taskmanager.repository.entity.TachesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TachesDAO extends JpaRepository<TachesEntity, Long> {
    List<TachesEntity> findTachesEntityByTitreContainingIgnoreCase(String titre);
}
