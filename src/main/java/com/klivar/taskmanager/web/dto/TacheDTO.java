package com.klivar.taskmanager.web.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TacheDTO(
        Long id,
        String titre,
        String description,
        LocalDate dateEcheance,
        int priorite,
        Long statutId,
        Long categorieId,
        Long utilisateurId
){}
