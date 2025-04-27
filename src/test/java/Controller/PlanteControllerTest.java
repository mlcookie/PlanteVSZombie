package Controller;

import com.epf.API.PlanteController;
import com.epf.API.PlanteDTO;
import com.epf.Core.Plante;
import com.epf.Core.Service.PlanteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlanteControllerTest {

    @Mock
    private PlanteService planteService;

    @InjectMocks
    private PlanteController planteController;

    public PlanteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPlantes() {
        Plante plante = new Plante();
        when(planteService.getAllPlantes()).thenReturn(List.of(plante));

        ResponseEntity<List<PlanteDTO>> response = planteController.getAllPlantes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetPlanteById() {
        Plante plante = new Plante();
        when(planteService.getPlanteById(1)).thenReturn(plante);

        ResponseEntity<PlanteDTO> response = planteController.getPlanteById(1);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testAddPlante() {
        PlanteDTO planteDTO = new PlanteDTO();
        ResponseEntity<Void> response = planteController.addPlante(planteDTO);

        verify(planteService, times(1)).addPlante(any(Plante.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdatePlante() {
        PlanteDTO planteDTO = new PlanteDTO();
        ResponseEntity<Void> response = planteController.updatePlante(1, planteDTO);

        verify(planteService, times(1)).updatePlante(any(Plante.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testDeletePlante() {
        ResponseEntity<Void> response = planteController.deletePlante(1);

        verify(planteService, times(1)).deletePlante(1);
        assertEquals(200, response.getStatusCodeValue());
    }
}
