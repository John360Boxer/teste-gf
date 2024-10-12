package com.digimon.teste_gf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digimon.teste_gf.model.Digimon;
import java.util.List;
import com.digimon.teste_gf.service.DigimonService;

//Criação das rotas
@RestController("api/digimon")
public class DigimonController {
    private final DigimonService digimonService;

    public DigimonController(DigimonService digimonService) {
        this.digimonService = digimonService;
    }

    @GetMapping()
    public List<Digimon> getAll() {
        return this.digimonService.findAll();
    }

    @GetMapping("name")
    public Digimon getByName(String name) {
        return this.digimonService.findByName(name);
    }

    @GetMapping("level")
    public List<Digimon> getByLevel(String level) {
        return this.digimonService.findByLevel(level);
    }
}
