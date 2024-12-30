package com.klivar.taskmanager.repository.dao;

import com.klivar.taskmanager.repository.entity.UtilisateursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursDAO extends JpaRepository<UtilisateursEntity, Long> {
}
