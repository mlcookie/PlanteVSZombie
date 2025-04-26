import com.epf.API.MapController;
import com.epf.Core.Map;
import com.epf.Core.Service.MapService;
import com.epf.API.MapDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

public class MapControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MapService mapService;  // Mock du service Map

    @InjectMocks
    private MapController mapController;  // Le contrôleur à tester

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialiser les mocks
        mockMvc = MockMvcBuilders.standaloneSetup(mapController).build(); // Configurer MockMvc
    }

    @Test
    public void testGetAllMaps() throws Exception {
        // Création de quelques objets MapDTO simulés
        MapDTO mapDTO1 = new MapDTO(new Map(1, "Map1", "Description1", "path1"));
        MapDTO mapDTO2 = new MapDTO(new Map(2, "Map2", "Description2", "path2"));

        List<MapDTO> maps = Arrays.asList(mapDTO1, mapDTO2);

        // Configuration du mock pour le service
        when(mapService.getAllMaps()).thenReturn(Arrays.asList(new Map(1, "Map1", "Description1", "path1"), new Map(2, "Map2", "Description2", "path2")));

        // Effectuer la requête GET et vérifier la réponse
        mockMvc.perform(get("/maps"))
                .andExpect(status().isOk())  // Vérifier que la réponse a un statut 200 OK
                .andExpect(jsonPath("$[0].id").value(1))  // Vérifier le premier map
                .andExpect(jsonPath("$[0].name").value("Map1"))
                .andExpect(jsonPath("$[1].id").value(2))  // Vérifier le deuxième map
                .andExpect(jsonPath("$[1].name").value("Map2"));
    }

    @Test
    public void testGetMapById() throws Exception {
        // Création d'un MapDTO simulé
        MapDTO mapDTO = new MapDTO(new Map(1, "Map1", "Description1", "path1"));

        // Configuration du mock pour le service
        when(mapService.getMapById(1)).thenReturn(new Map(1, "Map1", "Description1", "path1"));

        // Effectuer la requête GET et vérifier la réponse
        mockMvc.perform(get("/maps/1"))
                .andExpect(status().isOk())  // Vérifier que la réponse a un statut 200 OK
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Map1"));
    }

    @Test
    public void testGetMapById_NotFound() throws Exception {
        // Le service retourne null pour un ID inexistant
        when(mapService.getMapById(999)).thenReturn(null);

        // Effectuer la requête GET pour un ID inexistant et vérifier que la réponse est 404
        mockMvc.perform(get("/maps/999"))
                .andExpect(status().isNotFound());  // Vérifier que la réponse a un statut 404 Not Found
    }

    @Test
    public void testAddMap() throws Exception {
        // Création d'un MapDTO simulé
        MapDTO mapDTO = new MapDTO(new Map(0, "Map3", "Description3", "path3"));

        // Effectuer la requête POST et vérifier la réponse
        mockMvc.perform(post("/maps")
                        .contentType("application/json")
                        .content("{\"name\": \"Map3\", \"description\": \"Description3\", \"path\": \"path3\"}"))
                .andExpect(status().isCreated());  // Vérifier que la réponse a un statut 201 Created
    }

    @Test
    public void testUpdateMap() throws Exception {
        // Création d'un MapDTO simulé
        MapDTO mapDTO = new MapDTO(new Map(1, "UpdatedMap", "UpdatedDescription", "updatedPath"));

        // Effectuer la requête PUT et vérifier la réponse
        mockMvc.perform(put("/maps/1")
                        .contentType("application/json")
                        .content("{\"name\": \"UpdatedMap\", \"description\": \"UpdatedDescription\", \"path\": \"updatedPath\"}"))
                .andExpect(status().isOk());  // Vérifier que la réponse a un statut 200 OK
    }

    @Test
    public void testDeleteMap() throws Exception {
        // Effectuer la requête DELETE et vérifier la réponse
        mockMvc.perform(delete("/maps/1"))
                .andExpect(status().isOk());  // Vérifier que la réponse a un statut 200 OK
    }

    @Test
    public void testTestConnexion() throws Exception {
        // Test de la connexion à la base de données
        mockMvc.perform(get("/maps/test-connexion"))
                .andExpect(status().isOk())
                .andExpect(content().string("Connexion réussie à la base de données! Résultat : 1"));
    }
}
