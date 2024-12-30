package com.klivar.taskmanager.domain.mapper;

import com.klivar.taskmanager.repository.entity.CategoriesEntity;
import com.klivar.taskmanager.repository.entity.StatutsEntity;
import com.klivar.taskmanager.repository.entity.TachesEntity;
import com.klivar.taskmanager.repository.entity.UtilisateursEntity;
import com.klivar.taskmanager.web.dto.TacheDTO;

import java.util.List;

public class TachesMapper {

    public static TacheDTO toDTO(TachesEntity taches) {
        return new TacheDTO(
                taches.getId(),
                taches.getTitre(),
                taches.getDescription(),
                taches.getDateEcheance(),
                taches.getPriorite(),
                taches.getStatutId().getId(),
                taches.getCategorieId().getId(),
                taches.getUtilisateurId().getId()
        );
    }

    public static List<TacheDTO> toList(List<TachesEntity> tachesEntities){
        return tachesEntities.stream()
                .map(TachesMapper::toDTO)
                .toList();
    }
}
