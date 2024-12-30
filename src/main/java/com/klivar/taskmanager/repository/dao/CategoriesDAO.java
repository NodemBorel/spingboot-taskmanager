package com.klivar.taskmanager.repository.dao;

import com.klivar.taskmanager.repository.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDAO extends JpaRepository<CategoriesEntity, Long> {
}
