import com.epf.Core.Map;
import com.epf.Persistance.MapDAO;
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
public class MapDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private MapDAO mapDAO;

    @Test
    void testGetAllMaps() {
        Map map1 = new Map();
        map1.setId(1);
        map1.setLigne(2);
        map1.setColonne(3);
        map1.setCheminImage("image1.jpg");

        Map map2 = new Map();
        map2.setId(2);
        map2.setLigne(4);
        map2.setColonne(5);
        map2.setCheminImage("image2.jpg");

        List<Map> maps = Arrays.asList(map1, map2);

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class))).thenReturn(maps);

        List<Map> result = mapDAO.getAllMaps();

        assertEquals(2, result.size());
        assertEquals("image1.jpg", result.get(0).getCheminImage());
    }

    @Test
    void testGetMapById() {
        Map map = new Map();
        map.setId(1);
        map.setLigne(2);
        map.setColonne(3);
        map.setCheminImage("image1.jpg");

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(RowMapper.class), Mockito.anyInt())).thenReturn(map);

        Map result = mapDAO.getMapById(1);

        assertEquals(1, result.getId());
        assertEquals("image1.jpg", result.getCheminImage());
    }

    @Test
    void testAddMap() {
        Map map = new Map();
        map.setLigne(2);
        map.setColonne(3);
        map.setCheminImage("image1.jpg");

        mapDAO.addMap(map);

        verify(jdbcTemplate).update(Mockito.anyString(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void testDeleteMap() {
        mapDAO.deleteMap(1);

        verify(jdbcTemplate).update(Mockito.anyString(), Mockito.anyInt());
    }
}
