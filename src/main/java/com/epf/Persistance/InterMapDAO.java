package com.epf.Persistance;
import com.epf.Core.Map;

import java.util.List;

public interface InterMapDAO {
    void ajouter(Map map);
    Map trouverParId(int id);
    List<Map> listerToutes();
    void mettreAJour(Map map);
    void supprimer(int id);
}
