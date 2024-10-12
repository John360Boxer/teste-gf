package com.digimon.teste_gf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digimon.teste_gf.service.DigimonService;

@SpringBootApplication
	public class DigimonApplication implements CommandLineRunner {

		@Autowired
		private DigimonService digimonService;

		public static void main(String[] args) {
			SpringApplication.run(DigimonApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			//Busca por novos Digimons ao iniciar aplicação
			digimonService.fetchAndSaveDigimons();
		}
	}
//Comentar código
//Teste unitário usando o JUNIT
//Documentar o swagger
//readme -> github