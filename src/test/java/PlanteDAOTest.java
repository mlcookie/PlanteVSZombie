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
        Plante plante = new Plante();
        plante.setNom("Plante1");
        plante.setPointDeVie(100);
        plante.setAttaqueParSeconde(5.0);

        planteDAO.addPlante(plante);

        verify(jdbcTemplate).update(Mockito.anyString(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void testDeletePlante() {
        planteDAO.deletePlante(1);

        verify(jdbcTemplate).update(Mockito.anyString(), Mockito.anyInt());
    }
}
