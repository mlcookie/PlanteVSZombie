package Controller;

import com.epf.API.ZombieController;
import com.epf.API.ZombieDTO;
import com.epf.Core.Zombies;
import com.epf.Core.Service.ZombieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZombieControllerTest {

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    public ZombieControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    private Zombies createZombie() {
        return new Zombies(1, "ZombieTest", 100, 1.5, 20, 1.0, "chemin/image.png", 1);
    }

    private ZombieDTO createZombieDTO() {
        ZombieDTO dto = new ZombieDTO();
        dto.setId_zombie(1);
        dto.setNom("ZombieTest");
        dto.setPoint_de_vie(100);
        dto.setAttaque_par_seconde(1.5);
        dto.setDegat_attaque(20);
        dto.setVitesse_de_deplacement(1.0);
        dto.setChemin_image("chemin/image.png");
        dto.setId_map(1);
        return dto;
    }

    @Test
    void testGetAllZombies() {
        Zombies zombie = createZombie();
        when(zombieService.getAllZombies()).thenReturn(List.of(zombie));

        ResponseEntity<List<ZombieDTO>> response = zombieController.getAllZombies();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("ZombieTest", response.getBody().get(0).getNom());
    }

    @Test
    void testGetZombieById() {
        Zombies zombie = createZombie();
        when(zombieService.getZombieById(1)).thenReturn(zombie);

        ResponseEntity<ZombieDTO> response = zombieController.getZombieById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("ZombieTest", response.getBody().getNom());
    }

    @Test
    void testAddZombie() {
        ZombieDTO zombieDTO = createZombieDTO();
        ResponseEntity<Void> response = zombieController.addZombie(zombieDTO);

        verify(zombieService, times(1)).addZombie(any(Zombies.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateZombie() {
        ZombieDTO zombieDTO = createZombieDTO();
        ResponseEntity<Void> response = zombieController.updateZombie(1, zombieDTO);

        verify(zombieService, times(1)).updateZombie(any(Zombies.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testDeleteZombie() {
        ResponseEntity<Void> response = zombieController.deleteZombie(1);

        verify(zombieService, times(1)).deleteZombie(1);
        assertEquals(200, response.getStatusCodeValue());
    }
}
