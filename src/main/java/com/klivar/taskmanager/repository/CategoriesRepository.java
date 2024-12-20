package com.klivar.taskmanager.repository;

import com.klivar.taskmanager.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
