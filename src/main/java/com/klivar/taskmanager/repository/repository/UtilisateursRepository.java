package com.klivar.taskmanager.repository.repository;


import com.klivar.taskmanager.repository.dao.UtilisateursDAO;
import com.klivar.taskmanager.repository.entity.UtilisateursEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UtilisateursRepository{

    @Autowired
    private UtilisateursDAO utilisateursDAO;

    public Optional<UtilisateursEntity> findById(Long id) {
        return utilisateursDAO.findById(id);
    }
}
