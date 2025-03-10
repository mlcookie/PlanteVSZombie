package com.epf.Persistance;
import com.epf.Core.Map;

import java.util.List;

public interface InterMapDAO {
    List<Map> getAllMaps();
    Map getMapById(int id);
    void addMap(Map map);
    void updateMap(Map map);
    void deleteMap(int id);
}




