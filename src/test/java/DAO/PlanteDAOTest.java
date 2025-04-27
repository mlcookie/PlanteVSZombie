package DAO;

import com.epf.Core.Plante;
import com.epf.Persistance.PlanteDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlanteDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PlanteDAO planteDAO;

    @Test
    void testGetAllPlantes() {
        Plante plante1 = new Plante();
        plante1.setId(1);
        plante1.setNom("Plante1");
        plante1.setPointDeVie(100);
        plante1.setAttaqueParSeconde(5.0);

        Plante plante2 = new Plante();
        plante2.setId(2);
        plante2.setNom("Plante2");
        plante2.setPointDeVie(120);
        plante2.setAttaqueParSeconde(6.0);

        List<Plante> plantes = Arrays.asList(plante1, plante2);

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class))).thenReturn(plantes);

        List<Plante> result = planteDAO.getAllPlantes();

        assertEquals(2, result.size());
        assertEquals("Plante1", result.get(0).getNom());
    }

    @Test
    void testGetPlanteById() {
        Plante plante = new Plante();
        plante.setId(1);
        plante.setNom("Plante1");
        plante.setPointDeVie(100);
        plante.setAttaqueParSeconde(5.0);

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(RowMapper.class), Mockito.anyInt())).thenReturn(plante);

        Plante result = planteDAO.getPlanteById(1);

        assertEquals("Plante1", result.getNom());
    }

    @Test
    void testAddPlante() {
        // Créer une instance de Plante avec l'effet `Effet.NORMAL`
        Plante plante = new Plante("Plante1", 100, 5.0d, 0, 0, 0.0d, Plante.Effet.NORMAL, null);

        // Simuler l'invocation de la méthode addPlante
        jdbcTemplate.update(
                "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(),
                plante.getPointDeVie(),
                plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(),
                plante.getCout(),
                plante.getSoleilParSeconde(),
                plante.getEffet().toString(),  // Utilisation de l'énumération Effet
                plante.getCheminImage()
        );

        // Ajoute les assertions nécessaires pour vérifier que la plante a été correctement ajoutée
    }


    @Test
    void testDeletePlante() {
        planteDAO.deletePlante(1);

        verify(jdbcTemplate).update(Mockito.anyString(), Mockito.anyInt());
    }
}
