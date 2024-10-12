package com.digimon.teste_gf.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digimon.teste_gf.model.Digimon;
import com.digimon.teste_gf.repository.DigimonRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Service
public class DigimonService {
    private final DigimonRepository digimonRepository;

    public DigimonService(DigimonRepository digimonRepository) {
        this.digimonRepository = digimonRepository;
    }

    public void register(Digimon digimon) {
        this.digimonRepository.save(digimon);
    }

    public Digimon findByName(String name) {
        return this.digimonRepository.findByName(name);
    }

    public List<Digimon> findByLevel(String level) {
        return this.digimonRepository.findByLevel(level);
    }

    public List<Digimon> findAll() {
        return this.digimonRepository.findAll();
    }

    //Busca Digimons na API para salvá-los no BD
    @Transactional
    public void fetchAndSaveDigimons() throws IOException {
        String apiUrl = "https://digimon-api.vercel.app/api/digimon";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Erro ao conectar com API: " + connection.getResponseCode());
        }

        //Pega os valores na API baseados no modelo do Digimon
        ObjectMapper objectMapper = new ObjectMapper();
        List<Digimon> digimons = objectMapper.readValue(connection.getInputStream(), new TypeReference<List<Digimon>>() {});

        connection.disconnect();

        //Verifica se o Digimon já está presente no BD. Caso não esteja, o adiciona no BD, e caso contrário não faz nada
        for (Digimon digimon : digimons) {
            if (!digimonRepository.existsByName(digimon.getName())) {
                digimonRepository.save(digimon);
                System.out.println("Salvando Digimon " + digimon.getName() + "no BD");
            } else {
                System.out.println("Digimon " + digimon.getName() + "já existe no BD");
            }
        }
    }
}
