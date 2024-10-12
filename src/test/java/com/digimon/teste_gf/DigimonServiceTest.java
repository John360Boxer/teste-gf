package com.digimon.teste_gf;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.digimon.teste_gf.model.Digimon;
import com.digimon.teste_gf.repository.DigimonRepository;
import com.digimon.teste_gf.service.DigimonService;
import java.util.ArrayList;
import java.util.List;

public class DigimonServiceTest {

    //Os testes são feitos localmente, simulando um BD
    @Mock
    private DigimonRepository digimonRepository;

    @InjectMocks
    private DigimonService digimonService;

    //Digimons para uso em testes
    private Digimon yokomon;        //Nível In Training
    private Digimon koromon;        //Nível Rookie
    private Digimon wereGarurumon;  //Nível Champion
    private List<Digimon> digimonList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        yokomon = new Digimon();
        yokomon.setName("Yokomon");
        yokomon.setLevel("In Training");
        yokomon.setImg("https://digimon.shadowsmith.com/img/yokomon.jpg");

        koromon = new Digimon();
        koromon.setName("Koromon");
        koromon.setLevel("Rookie");
        koromon.setImg("https://digimon.shadowsmith.com/img/koromon.jpg");

        wereGarurumon = new Digimon();
        wereGarurumon.setName("WereGarurumon");
        wereGarurumon.setLevel("Ultimate");
        wereGarurumon.setImg("https://digimon.shadowsmith.com/img/wereGarurumon.jpg");

        digimonList = new ArrayList<>();
        digimonList.add(koromon);
        digimonList.add(wereGarurumon);
        digimonList.add(yokomon);
    }

    @Test   //Busca de todos os Digimons no BD
    public void testGetAllDigimons() {
        when(digimonRepository.findAll()).thenReturn(digimonList);

        List<Digimon> result = digimonService.findAll();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Koromon", result.get(0).getName());
        assertEquals("WereGarurumon", result.get(1).getName());
        assertEquals("Yokomon", result.get(2).getName());
    }

    @Test   //Busca de Digimon no BD por meio do nome
    public void testGetDigimonByName() {
        when(digimonRepository.findByName("Koromon")).thenReturn(koromon);

        Digimon result = digimonService.findByName("Koromon");

        assertNotNull(result);
        assertEquals("Koromon", result.getName());
        assertEquals("Rookie", result.getLevel());
    }

    @Test   //Busca de Digimon no BD por meio do nível
    public void testGetDigimonsByLevel() {
        List<Digimon> rookieDigimons = new ArrayList<>();
        rookieDigimons.add(koromon);

        when(digimonRepository.findByLevel("Rookie")).thenReturn(rookieDigimons);

        List<Digimon> result = digimonService.findByLevel("Rookie");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Koromon", result.get(0).getName());
        assertEquals("Rookie", result.get(0).getLevel());
    }
}