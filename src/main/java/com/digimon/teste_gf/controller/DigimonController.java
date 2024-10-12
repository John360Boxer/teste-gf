package com.digimon.teste_gf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digimon.teste_gf.model.Digimon;
import java.util.List;
import com.digimon.teste_gf.service.DigimonService;

@RestController("api/digimon")  //Criação das rotas
public class DigimonController {
    private final DigimonService digimonService;

    public DigimonController(DigimonService digimonService) {
        this.digimonService = digimonService;
    }

    @GetMapping()               //Retorna todos os dados de todos os Digimons presentes no BD
    public List<Digimon> getAll() {
        return this.digimonService.findAll();
    }

    @GetMapping("name")         //Retorna todos os dados do Digimon referenciado, caso exista
    public Digimon getByName(String name) {
        return this.digimonService.findByName(name);
    }

    @GetMapping("level")        //Retorna todos os dados dos Digimons com o level referenciado, caso exista
    public List<Digimon> getByLevel(String level) {
        return this.digimonService.findByLevel(level);
    }
}
