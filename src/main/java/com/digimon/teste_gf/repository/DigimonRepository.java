package com.digimon.teste_gf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digimon.teste_gf.model.Digimon;

@Repository
public interface DigimonRepository extends JpaRepository <Digimon, Long> {
    Digimon findByName(String name);
    List<Digimon> findByLevel(String level);
    Boolean existsByName(String name);
}
