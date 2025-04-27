package Controller;

import com.epf.API.MapController;
import com.epf.API.MapDTO;
import com.epf.Core.Map;
import com.epf.Core.Service.MapService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapControllerTest {



    @Mock
    private MapService mapService;

    @InjectMocks
    private MapController mapController;

    public MapControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMaps() {
        Map map = new Map();
        when(mapService.getAllMaps()).thenReturn(List.of(map));

        ResponseEntity<List<MapDTO>> response = mapController.getAllMaps();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetMapByIdFound() {
        Map map = new Map();
        map.setId(1);
        when(mapService.getMapById(1)).thenReturn(map);

        ResponseEntity<MapDTO> response = mapController.getMapById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().getId_map());
    }

    @Test
    void testGetMapByIdNotFound() {
        when(mapService.getMapById(1)).thenReturn(null);

        ResponseEntity<MapDTO> response = mapController.getMapById(1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testAddMap() {
        MapDTO mapDTO = new MapDTO();
        ResponseEntity<Void> response = mapController.addMap(mapDTO);

        verify(mapService, times(1)).addMap(any(Map.class));
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void testUpdateMap() {
        MapDTO mapDTO = new MapDTO();
        ResponseEntity<Void> response = mapController.updateMap(1, mapDTO);

        verify(mapService, times(1)).updateMap(any(Map.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testDeleteMap() {
        ResponseEntity<Void> response = mapController.deleteMap(1);

        verify(mapService, times(1)).deleteMap(1);
        assertEquals(200, response.getStatusCodeValue());
    }
}
