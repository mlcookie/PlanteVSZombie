package DAO;

import com.epf.Core.Zombies;
import com.epf.Persistance.ZombiesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Utilisation de MockitoExtension pour initialiser les mocks
public class ZombieDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;  // Mock du JdbcTemplate

    @InjectMocks
    private ZombiesDAO zombiesDAO;  // Injection automatique des mocks dans l'objet zombiesDAO

    @BeforeEach
    void setUp() {
        zombiesDAO = new ZombiesDAO(jdbcTemplate); // Assurer l'injection manuelle
        assertNotNull(zombiesDAO, "zombiesDAO should not be null");
    }

    @Test
    void testZombieDAOIsNotNull() {
        assertNotNull(zombiesDAO, "zombiesDAO should not be null");
        assertNotNull(jdbcTemplate, "jdbcTemplate should be mocked");
    }

    @Test
    void testGetAllZombies() {
        Zombies zombie1 = new Zombies(1, "Zombie1", 100, 3.0, 10, 1.5, "image1.jpg", 1);
        Zombies zombie2 = new Zombies(2, "Zombie2", 150, 4.0, 15, 1.8, "image2.jpg", 2);
        List<Zombies> zombies = Arrays.asList(zombie1, zombie2);

        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(zombies);

        List<Zombies> result = zombiesDAO.getAllZombies();

        assertEquals(2, result.size());
        assertEquals("Zombie1", result.get(0).getNomZombie());
    }

    @Test
    void testGetZombieById() {
        Zombies zombie = new Zombies(1, "Zombie1", 100, 3.0, 10, 1.5, "image1.jpg", 1);

        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), anyInt())).thenReturn(zombie);

        Zombies result = zombiesDAO.getZombieById(1);

        assertEquals("Zombie1", result.getNomZombie());
    }

    @Test
    void testAddZombie() {
        // Créer un nouveau zombie
        Zombies zombie = new Zombies(1, "Zombie1", 100, 1.5d, 3, 10.0, "image1.jpg", 1);

        // Appeler la méthode addZombie
        zombiesDAO.addZombie(zombie);

        // Vérifier que la méthode update a bien été appelée une fois avec les bons arguments
        verify(jdbcTemplate, times(1)).update(
                eq("INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)"),
                eq(zombie.getNomZombie()),
                eq(zombie.getPointDeVieZombie()),
                eq(zombie.getAttaqueParSecondeZombie()),
                eq(zombie.getDegatParSeconde()),
                eq(zombie.getVitesseDeDeplacement()),
                eq(zombie.getCheminImage()),
                eq(zombie.getIdMap())
        );
    }

    @Test
    void testDeleteZombie() {
        zombiesDAO.deleteZombie(1);

        verify(jdbcTemplate).update(anyString(), eq(1));
    }
}
