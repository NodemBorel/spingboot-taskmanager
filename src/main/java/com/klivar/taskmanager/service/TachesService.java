package com.klivar.taskmanager.service;

import com.klivar.taskmanager.controller.TacheRequest;
import com.klivar.taskmanager.model.Categories;
import com.klivar.taskmanager.model.Statuts;
import com.klivar.taskmanager.model.Taches;
import com.klivar.taskmanager.model.Utilisateurs;
import com.klivar.taskmanager.repository.CategoriesRepository;
import com.klivar.taskmanager.repository.StatutsRepository;
import com.klivar.taskmanager.repository.TachesRepository;
import com.klivar.taskmanager.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Taches> getAllTaches(){
        return tachesRepository.findAll();
    }

    public Taches getTachesById(Long id){
        return tachesRepository.findById(id).orElseThrow(() -> new RuntimeException("Taches n'existe pas"));
    }

    public Taches createTaches(TacheRequest tacheRequest){
        Taches taches = new Taches();

        taches.setTitre(tacheRequest.getTitre());
        taches.setDescription(tacheRequest.getDescription());
        taches.setDateEcheance(tacheRequest.getDateEcheance());
        taches.setPriorite(tacheRequest.getPriorite());

        Statuts statuts = statutsRepository.findById(tacheRequest.getStatutId())
                .orElseThrow(() -> new RuntimeException("Statut pas trouver"));
        taches.setStatutId(statuts);

        Categories categories = categoriesRepository.findById(tacheRequest.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Categorie pas trouver"));
        taches.setCategorieId(categories);

        Utilisateurs utilisateur = utilisateursRepository.findById(tacheRequest.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur pas trouver"));
        taches.setUtilisateurId(utilisateur);

        return tachesRepository.save(taches);
    }

    public Taches updateTaches(Long id, TacheRequest tacheRequest){

        Taches taches = tachesRepository.findById(id).orElseThrow(()-> new RuntimeException("Tache pas trouver"));

        taches.setTitre(tacheRequest.getTitre());
        taches.setDescription(tacheRequest.getDescription());
        taches.setDateEcheance(tacheRequest.getDateEcheance());
        taches.setPriorite(tacheRequest.getPriorite());

        Statuts statut = statutsRepository.findById(tacheRequest.getStatutId())
                .orElseThrow(() -> new RuntimeException("Statut pas trouver"));
        taches.setStatutId(statut);

        Categories categorie = categoriesRepository.findById(tacheRequest.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Categorie pas trouver "));
        taches.setCategorieId(categorie);

        return tachesRepository.save(taches);
    }

    public List<Taches> searchTachesByTitre(String titre){
        return tachesRepository.findByTitre(titre);
    }

    public void deleteTaches(Long id){
        tachesRepository.deleteById(id);
    }
}
