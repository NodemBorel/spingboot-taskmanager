package com.klivar.taskmanager.repository;

import com.klivar.taskmanager.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {
}
