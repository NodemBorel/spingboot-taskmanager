package com.klivar.taskmanager.controller;

import com.klivar.taskmanager.model.Taches;
import com.klivar.taskmanager.service.TachesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TachesController {


    private final TachesService tachesService;

    public TachesController(TachesService tachesService) {
        this.tachesService = tachesService;
    }

    @GetMapping
    public List<Taches> getAllTaches(){
        return tachesService.getAllTaches();
    }

    @GetMapping("/{id}")
    public Taches getTachesById(@PathVariable Long id){
        return tachesService.getTachesById(id);
    }

    @PostMapping
    public Taches createTaches(@RequestBody TacheRequest tacheRequest){
        return tachesService.createTaches(tacheRequest);
    }

    @PutMapping("/{id}")
    public Taches updateTaches(@PathVariable Long id, @RequestBody TacheRequest tacheRequest){
        return tachesService.updateTaches(id, tacheRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTaches(@PathVariable Long id){
        tachesService.deleteTaches(id);
    }

    @GetMapping("/search")
    public List<Taches> searchTachesByTitre(@RequestParam String titre){
        return tachesService.searchTachesByTitre(titre);
    }
}
