package com.epf.Core.Service;
import com.epf.Core.Map;
import com.epf.Persistance.InterMapDAO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapService implements InterMapService {

    private final InterMapDAO mapDAO;

    public MapService(InterMapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public List<Map> getAllMaps() {
        return mapDAO.getAllMaps();
    }

    @Override
    public Map getMapById(int id) {
        return mapDAO.getMapById(id);
    }

    @Override
    public void addMap(Map map) {
        mapDAO.addMap(map);
    }

    @Override
    public void updateMap(Map map) {
        mapDAO.updateMap(map);
    }

    @Override
    public void deleteMap(int id) {
        mapDAO.deleteMap(id);
    }
}
