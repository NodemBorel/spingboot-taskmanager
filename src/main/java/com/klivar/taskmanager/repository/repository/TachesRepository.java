package com.klivar.taskmanager.repository.repository;

import com.klivar.taskmanager.repository.dao.TachesDAO;
import com.klivar.taskmanager.repository.entity.TachesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TachesRepository{

    @Autowired
    private TachesDAO tachesDAO;

    public Optional<TachesEntity> findById(Long id) {
        return tachesDAO.findById(id);
    }

    public List<TachesEntity> findAll() {
        return tachesDAO.findAll();
    }

    public TachesEntity save(TachesEntity taches) {
        return tachesDAO.save(taches);
    }

    public List<TachesEntity> findTachesEntityByTitreContainingIgnoreCase(String titre){
        return tachesDAO.findTachesEntityByTitreContainingIgnoreCase(titre);
    }

    public void deleteById(Long id) {
        tachesDAO.deleteById(id);
    }

}
