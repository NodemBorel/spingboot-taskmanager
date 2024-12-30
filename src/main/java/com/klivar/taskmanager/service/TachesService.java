package com.klivar.taskmanager.service;

import com.klivar.taskmanager.domain.mapper.TachesMapper;
import com.klivar.taskmanager.web.dto.TacheDTO;
import com.klivar.taskmanager.repository.entity.CategoriesEntity;
import com.klivar.taskmanager.repository.entity.StatutsEntity;
import com.klivar.taskmanager.repository.entity.TachesEntity;
import com.klivar.taskmanager.repository.entity.UtilisateursEntity;
import com.klivar.taskmanager.repository.repository.CategoriesRepository;
import com.klivar.taskmanager.repository.repository.StatutsRepository;
import com.klivar.taskmanager.repository.repository.TachesRepository;
import com.klivar.taskmanager.repository.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TachesService {

    @Autowired
    private TachesRepository tachesRepository;

    @Autowired
    private StatutsRepository statutsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    public List<TacheDTO> getAllTaches(){
        List<TachesEntity> tasks = tachesRepository.findAll();
        return TachesMapper.toList(tasks);
    }

    public TacheDTO getTachesById(Long id){
        return TachesMapper.toDTO(tachesRepository.findById(id).orElseThrow(() -> new RuntimeException("Taches n'existe pas")));
    }

    public TacheDTO createTaches(TacheDTO tacheDTO){
        TachesEntity taches = new TachesEntity();

        taches.setTitre(tacheDTO.titre());
        taches.setDescription(tacheDTO.description());
        taches.setDateEcheance(tacheDTO.dateEcheance());
        taches.setPriorite(tacheDTO.priorite());

        StatutsEntity statuts = statutsRepository.findById(tacheDTO.statutId())
                .orElseThrow(() -> new RuntimeException("Statut pas trouver"));
        taches.setStatutId(statuts);

        CategoriesEntity categories = categoriesRepository.findById(tacheDTO.categorieId())
                .orElseThrow(() -> new RuntimeException("Categorie pas trouver"));
        taches.setCategorieId(categories);

        UtilisateursEntity utilisateur = utilisateursRepository.findById(tacheDTO.utilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur pas trouver"));
        taches.setUtilisateurId(utilisateur);

        return TachesMapper.toDTO(tachesRepository.save(taches));
    }

    public TacheDTO updateTaches(Long id, TacheDTO tacheDTO){

        TachesEntity taches = tachesRepository.findById(id).orElseThrow(()-> new RuntimeException("Tache pas trouver"));

        taches.setTitre(tacheDTO.titre());
        taches.setDescription(tacheDTO.description());
        taches.setDateEcheance(tacheDTO.dateEcheance());
        taches.setPriorite(tacheDTO.priorite());

        StatutsEntity statut = statutsRepository.findById(tacheDTO.statutId())
                .orElseThrow(() -> new RuntimeException("Statut pas trouver"));
        taches.setStatutId(statut);

        CategoriesEntity categorie = categoriesRepository.findById(tacheDTO.categorieId())
                .orElseThrow(() -> new RuntimeException("Categorie pas trouver "));
        taches.setCategorieId(categorie);

        return TachesMapper.toDTO(tachesRepository.save(taches));
    }

    public List<TachesEntity> searchTachesByTitre(String titre){
        return tachesRepository.findTachesEntityByTitreContainingIgnoreCase(titre);
    }

    public void deleteTaches(Long id){
        tachesRepository.deleteById(id);
    }
}
