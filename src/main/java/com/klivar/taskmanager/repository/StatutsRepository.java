package com.klivar.taskmanager.repository;

import com.klivar.taskmanager.model.Statuts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutsRepository extends JpaRepository<Statuts, Long> {
}
