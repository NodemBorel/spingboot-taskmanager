package com.klivar.taskmanager.repository.repository;

import com.klivar.taskmanager.repository.dao.CategoriesDAO;
import com.klivar.taskmanager.repository.entity.CategoriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoriesRepository{

    @Autowired
    private CategoriesDAO categoriesDAO;

    public Optional<CategoriesEntity> findById(Long id) {
        return categoriesDAO.findById(id);
    }
}
