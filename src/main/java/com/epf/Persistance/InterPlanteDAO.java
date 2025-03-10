package com.epf.Persistance;
import com.epf.Core.Plante;

import java.util.List;

public interface InterPlanteDAO {
    List<Plante> getAllPlantes();
    Plante getPlanteById(int id);
    void addPlante(Plante plante);
    void updatePlante(Plante plante);
    void deletePlante(int id);
}

