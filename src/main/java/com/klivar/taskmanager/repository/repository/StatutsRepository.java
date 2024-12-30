package com.klivar.taskmanager.repository.repository;

import com.klivar.taskmanager.repository.dao.StatutsDAO;
import com.klivar.taskmanager.repository.entity.StatutsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StatutsRepository{

    @Autowired
    private StatutsDAO statutsDAO;

    public Optional<StatutsEntity> findById(Long id) {
        return statutsDAO.findById(id);
    }

}
