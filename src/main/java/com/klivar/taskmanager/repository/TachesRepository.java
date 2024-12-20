package com.klivar.taskmanager.repository;

import com.klivar.taskmanager.model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TachesRepository extends JpaRepository<Taches, Long> {

    @Query("SELECT t FROM Taches t WHERE LOWER(t.titre) LIKE LOWER(CONCAT('%', :titre, '%'))")
    List<Taches> findByTitre(@Param("titre") String titre);

}
