package com.klivar.taskmanager.web.controller;

import com.klivar.taskmanager.repository.entity.TachesEntity;
import com.klivar.taskmanager.service.TachesService;
import com.klivar.taskmanager.web.dto.TacheDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from this origin
@RequestMapping("/api/taches")
public class TachesController {


    private final TachesService tachesService;

    public TachesController(TachesService tachesService) {
        this.tachesService = tachesService;
    }

    @GetMapping
    public List<TacheDTO> getAllTaches(){
        return tachesService.getAllTaches();
    }

    @GetMapping("/{id}")
    public TacheDTO getTachesById(@PathVariable Long id){
        return tachesService.getTachesById(id);
    }

    @PostMapping
    public TacheDTO createTaches(@RequestBody TacheDTO tacheDTO){
        return tachesService.createTaches(tacheDTO);
    }

    @PutMapping("/{id}")
    public TacheDTO updateTaches(@PathVariable Long id, @RequestBody TacheDTO tacheDTO){
        return tachesService.updateTaches(id, tacheDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTaches(@PathVariable Long id){
        tachesService.deleteTaches(id);
    }

    @GetMapping("/search")
    public List<TachesEntity> searchTachesByTitre(@RequestParam String titre){
        return tachesService.searchTachesByTitre(titre);
    }
}
